package gui;

import misc.Editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelpBox extends Composite {
  private Editor editor;

  private StyledText helpbox;
  private Text search;
  private Button button;
  private String keyword;

  //Test string
  private static final String HELPTEXT1 = "Ein Hallo-Welt-Programm ist ein kleines " +
      "Computerprogramm.";
  private static final String HELPTEXT2 = "Das Standard Widget Toolkit (SWT) ist eine " +
      "Bibliothek für die Erstellung grafischer Oberflächen mit Java. Blahblah Welt...";

  public HelpBox(Shell parent, int style, Editor editor) {
    super(parent, style);
    this.editor = editor;

    //Setting the Layout
    GridLayout gLayout = new GridLayout();
    gLayout.numColumns = 4;
    this.setLayout(gLayout);
    GridData gData = new GridData(GridData.FILL_BOTH);
    this.setLayoutData(gData);

    //Create components of the help box
    Text helpboxheader = new Text(this, SWT.NONE);
    helpboxheader.setEnabled(false);
    helpboxheader.setBackground(new Color(helpboxheader.getDisplay(),
        142, 189, 247));
    helpboxheader.setText("Help");
    gData = new GridData(GridData.FILL_BOTH);
    gData.horizontalSpan = 4;
    gData.verticalSpan = 4;
    helpboxheader.setLayoutData(gData);

    this.helpbox = new StyledText(this, SWT.MULTI | SWT.WRAP | SWT.BORDER
        | SWT.H_SCROLL | SWT.V_SCROLL);
    this.helpbox.setEditable(false);
    this.helpbox.setText("Please insert a key word (i.e. hallo, welt)");
      gData = new GridData(GridData.FILL_BOTH);
      gData.horizontalSpan = 4;
      gData.verticalSpan = 18;
      this.helpbox.setLayoutData(gData);

      this.search = new Text(this, SWT.SINGLE | SWT.BORDER);
      this.search.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
      gData = new GridData(GridData.FILL_BOTH);
      gData.horizontalSpan = 3;
      gData.verticalSpan = 5;
      this.search.setLayoutData(gData);

      this.button = new Button(this, SWT.PUSH);
      this.button.setText("Search");
      gData = new GridData(GridData.FILL_BOTH);
      gData.verticalSpan = 5;
      this.button.setLayoutData(gData);

      //Add events
      //TODO Remove Controller & Model
      this.button.addSelectionListener(new SelectionAdapter() {
        public void widgetSelected(SelectionEvent e) {
          keyword = search.getText();
          if (keyword == null || keyword.length() == 0) {
              return;
          }
          String text = "";
          if (HELPTEXT1.toLowerCase().contains(keyword.toLowerCase())) {
            text = text + HELPTEXT1 + "\n";
          }
          if (HELPTEXT2.toLowerCase().contains(keyword.toLowerCase())) {
            text = text + HELPTEXT2 + "\n";
          }

          helpbox.setText(text);
          helpbox.redraw();
        }
      });
  }
}
