package swtsample;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * This snippet represents usage of the ComboBoxCell-Editor
 * 
 * @author Tom Schindl <tom.schindl@bestsolution.at>
 * 
 */
public class TestTable {
    private class MyCellModifier implements ICellModifier {

        private TableViewer viewer;

        public MyCellModifier(TableViewer viewer) {
            this.viewer = viewer;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object,
         *      java.lang.String)
         */
        public boolean canModify(Object element, String property) {
            return true;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object,
         *      java.lang.String)
         */
        public Object getValue(Object element, String property) {
            // We need to calculate back to the index
            return new Integer(((MyModel) element).counter / 10);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object,
         *      java.lang.String, java.lang.Object)
         */
        public void modify(Object element, String property, Object value) {
            TableItem item = (TableItem) element;
            // We get the index and need to calculate the real value
            ((MyModel) item.getData()).counter = ((Integer) value).intValue() * 10;
            viewer.update(item.getData(), null);
        }
    }

    private class MyContentProvider implements IStructuredContentProvider {

 
        public Object[] getElements(Object inputElement) {
            return (MyModel[]) inputElement;
        }


        public void dispose() {

        }
        
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

        }

    }

    public class MyModel {
        public int counter;

        public MyModel(int counter) {
            this.counter = counter;
        }

        public String toString() {
            return "Item " + this.counter;
        }
    }

    public TestTable(Shell shell) {
        final Table table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        final TableViewer v = new TableViewer(table); //放到table
        final MyCellModifier modifier = new MyCellModifier(v);//设置成全局而已

        TableColumn column = new TableColumn(table, SWT.NONE);//放一个列
        column.setWidth(200);

        v.setLabelProvider(new LabelProvider());
        v.setContentProvider(new MyContentProvider());
        v.setCellModifier(modifier);
        
        v.setColumnProperties(new String[] { "column1" });
        v.setCellEditors(new CellEditor[] { new ComboBoxCellEditor(
                v.getTable(), new String[] { "Zero", "Ten", "Twenty", "Thirty",
                        "Fourty", "Fifty", "Sixty", "Seventy", "Eighty",
                        "Ninety" }) });
        MyModel[] model = createModel();
        v.setInput(model);
        v.getTable().setLinesVisible(true);
    }

    private MyModel[] createModel() {
        MyModel[] elements = new MyModel[1];

       
            elements[0] = new MyModel( 9);
    

        return elements;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        new TestTable(shell);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

}