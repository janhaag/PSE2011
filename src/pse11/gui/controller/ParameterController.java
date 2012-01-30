package gui.controller;

import java.util.ArrayList;

import interpreter.GlobalBreakpoint;
import interpreter.StatementBreakpoint;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import ast.ArrayType;
import ast.BooleanType;
import ast.FunctionParameter;
import ast.IntegerType;
import ast.Type;

import misc.ExecutionHandler;
import misc.MessageCategories;
import misc.MessageSystem;
import gui.ParameterFrame;
import gui.RandomTestFrame;

/**
 * This class is responsible for controlling the views @see{ParameterFrame},
 * @see{RandomTestFrame} and uses the models @see{MessageSystem}, 
 * @see{ExecutionHandler}.
 */
public class ParameterController implements SelectionListener {
	/**
	 * view for parameter input
	 */
	private ParameterFrame parameterframe;
	/**
	 * view for random test interval input
	 */
	private RandomTestFrame randomtestframe;
	/**
	 * model for random test output
	 */
	private MessageSystem messagesystem;
	/**
	 * model for parameter input
	 */
	private ExecutionHandler executionHandler;
	
	/**
	 * Construct a parameter controller with the specified models.
	 * @param executionHandler specified model
	 * @param messagesystem specified model
	 */
	public ParameterController(ExecutionHandler executionHandler, MessageSystem messagesystem) {
		this.messagesystem = messagesystem;
		this.executionHandler = executionHandler;
	}

	/**
	 * Add the specified frame as view.
	 * @param parameterframe specified view
	 */
	public void addParameterFrame(ParameterFrame parameterframe) {
		if (this.executionHandler.getAST() != null && this.executionHandler.getAST().getMainFunction().getParameters() != null) {
			this.parameterframe = parameterframe;
			this.parameterframe.createFrame(this.executionHandler.getAST().getMainFunction().getParameters());
			this.parameterframe.getOkButton().addSelectionListener(this);
		}		
	}
	
	/**
	 * Add the specified frame as view. An empty view might be created 
	 * if the source code does not have correct syntax or parameters.
	 * @param randomtestframe specified view
	 * @param source program code to be checked
	 */
	public void addRandomTestFrame(RandomTestFrame randomtestframe, String source) {
		this.randomtestframe = randomtestframe;
		this.executionHandler.parse(source);
		if (this.executionHandler.getAST() == null) {
			this.randomtestframe.createEmptyFrame("Please make sure that the syntax is correct!");
		}
		else if (this.executionHandler.getAST().getMainFunction().getParameters() == null
				|| this.executionHandler.getAST().getMainFunction().getParameters().length == 0) {
			this.randomtestframe.createEmptyFrame("Main function does not have parameters!");
			this.executionHandler.setAST(null);
		}
		else {
			this.randomtestframe.createFrame(this.executionHandler.getAST().getMainFunction().getParameters()); 
			this.randomtestframe.getStartButton().addSelectionListener(this);
		}
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		if (this.parameterframe != null && e.getSource() == this.parameterframe.getOkButton()) {
			String[] parameterValues = new String[this.parameterframe.getValues().length];
			for (int i = 0; i < this.parameterframe.getValues().length; i++) {
				parameterValues[i] = "";
				parameterValues[i] += this.parameterframe.getValues()[i].getText();
			}
			this.executionHandler.setParameterValues(parameterValues);
			this.parameterframe.getShell().dispose();
		}
		else if (this.randomtestframe != null && e.getSource() == this.randomtestframe.getStartButton()) {			
			String s = this.getRandomtestframe().getCount().getText();
			int count;
			try {
				count = Integer.parseInt(s);
			}
			catch (NumberFormatException ne) {
				count = 0;
			}
			String[] result = new String[2];
			this.messagesystem.clear(MessageCategories.MISC);
			for (int i = 0; i < count; i++) {
				FunctionParameter[] parameters = this.executionHandler.getAST().getMainFunction().getParameters();
				String[] parameterValues = this.createRandomTestValues(parameters);
				result[0] = "";
				for (int j = 0; j < parameterValues.length; j++) {
					result[0] = result[0] + parameters[j].getName().toString() + " = " 
					+ parameterValues[j] + "; ";
				}
				this.executionHandler.setParameterValues(parameterValues);
				this.executionHandler.run(new ArrayList<StatementBreakpoint>(), new ArrayList<GlobalBreakpoint>());
				if (this.executionHandler.getAssertionFailureMessage() == null) {
					result[1] = "success";
				}
				else {
					result[1] = this.executionHandler.getAssertionFailureMessage()[1]
					+ " (line " + this.executionHandler.getAssertionFailureMessage()[0] + ")";
					this.executionHandler.clearAssertionFailureMessage();
				}
				this.executionHandler.destroyProgramExecution();
				this.messagesystem.addMessage(MessageCategories.MISC, (i + 1), result[0], result[1]);
			}
			this.executionHandler.setAST(null);
			this.randomtestframe.getShell().dispose();
		}
	}
	private void test(IntegerType type) {
		System.out.println("int");
	}
	private void test(Type type) {
		System.out.println("void");
	}
	private void test(BooleanType type) {
		System.out.println("type");
	}
	private String[] createRandomTestValues(FunctionParameter[] parameters) {
		String[] parameterValues = new String[parameters.length];
		for (int i = 0; i < parameters.length; i++) {
			System.out.println(parameters[i].getType().toString());
			test(parameters[i].getType());
			if (parameters[i].getType() instanceof IntegerType) {
				String beginString = this.getRandomtestframe().getIntervals()[i][0].getText();
				String endString = this.getRandomtestframe().getIntervals()[i][1].getText();
				int begin;
				int end;
				int random;
				try {
					begin = Integer.parseInt(beginString);
					end = Integer.parseInt(endString);
					if (begin < end) {
						random = this.createRandomIntegerValue(begin, end);
					}
					else {
						random = 0;
					}
				}
				catch (NumberFormatException ne) {
					random = 0;
				}
				parameterValues[i] = random + "";
			}
			else if (parameters[i].getType() instanceof BooleanType) {
				parameterValues[i] = this.createRandomBooleanValue() + "";
			}
			else if (parameters[i].getType() instanceof ArrayType) {
				String sizeString = this.getRandomtestframe().getIntervals()[i][2].getText();
				int size;
				try {
					size = Integer.parseInt(sizeString);
				}
				catch (NumberFormatException ne) {
					size = 1;
				}
				Type tmp = parameters[i].getType();
				int dimension = 0;
				while (tmp instanceof ArrayType) {
					tmp = ((ArrayType) tmp).getType();
					dimension++;
				}
				String value = "";
				if (tmp instanceof IntegerType) {
					String beginString = this.getRandomtestframe().getIntervals()[i][0].getText();
					String endString = this.getRandomtestframe().getIntervals()[i][1].getText();
					int begin;
					int end;
					try {
						begin = Integer.parseInt(beginString);
						end = Integer.parseInt(endString);
						if (begin < end) {
							for (int j = 0; j < Math.pow(size, dimension - 1); j++) {
								for (int k = 1; k < dimension; k++) {
									if (j % Math.pow(size, k) == 0) {
										value += "{";
									}
								}
								value += this.createRandomIntegerArray(begin, end, size);
								for (int l = 1; l < dimension; l++) {
									if (j % Math.pow(size, l) == Math.pow(size, l) - 1) {
										value += "}";
									}
									else {
										value += ",";
										l = dimension;
									}
								}
							}
						}
						else {
							value = "0";
							for (int a = 0; a < size; a++) {
								value = "{" + value +"}";
							}
						}
					}
					catch (NumberFormatException ne) {
						value = "0";
						for (int a = 0; a < size; a++) {
							value = "{" + value +"}";
						}
					}
				}
				else if (tmp instanceof BooleanType) {
					for (int j = 0; j < Math.pow(size, dimension - 1); j++) {
						for (int k = 1; k < dimension; k++) {
							if (j % Math.pow(size, k) == 0) {
								value += "{";
							}
						}
						value += this.createRandomBooleanArray(size);
						for (int l = 1; l < dimension; l++) {
							if (j % Math.pow(size, l) == Math.pow(size, l) - 1) {
								value += "}";
							}
							else {
								value += ",";
								l = dimension;
							}
						}
					}
				}
				parameterValues[i] = value;
			}
		}
		return parameterValues;
	}
	
	/**
	 * Create a random integer number from the specified interval.
	 * @param begin start of the interval
	 * @param end end of the interval
	 * @return created number
	 */
	private int createRandomIntegerValue(int begin, int end) {
		return (int) (Math.random() * (end - begin + 1)) + begin;
	}
	
	/**
	 * Create a random boolean value.
	 * @return created value
	 */
	private boolean createRandomBooleanValue() {
		float random = (float) Math.random();
		return random > 0.5; 
	}
	
	/**
	 * Create a random one dimensional array of integer numbers from 
	 * the specified interval.
	 * @param begin start of the interval
	 * @param end end of the interval
	 * @param size size of the array
	 * @return created integer array
	 */
	private String createRandomIntegerArray(int begin, int end, int size) {
		String random = "";
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				random += this.createRandomIntegerValue(begin, end);
			}
			else {
				random += this.createRandomIntegerValue(begin, end) + ",";
			}
		}
		random = "{" + random + "}";
		return random;
	}
	
	/**
	 * Create a random one dimensional boolean array.
	 * @param size size of the array
	 * @return created boolean array
	 */
	private String createRandomBooleanArray(int size) {
		String random = "";
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				random += this.createRandomBooleanValue();
			}
			else {
				random += this.createRandomBooleanValue() + ",";
			}
		}
		random = "{" + random + "}";
		return random;
	}

	/**
	 * Return the parameter frame of this controller.
	 * @return parameter frame
	 */
	public ParameterFrame getParameterframe() {
		return this.parameterframe;
	}
	
	/**
	 * Return the random test frame of this controller.
	 * @return random test frame
	 */
	public RandomTestFrame getRandomtestframe() {
		return this.randomtestframe;
	}
	
	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
	}
}
