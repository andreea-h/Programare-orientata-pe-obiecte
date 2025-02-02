
import java.util.*;
//prin clasa tabel se doreste modelarea unui tabel 
//care sa poata reprezenta casute de orice tip
class Table {
	
	interface Printer {
        void print(Vector<Vector<Object>> rows);
    }
    public Vector<Vector<Object>> rows;
    public Table(Object[][] data) {
        rows=new Vector<Vector<Object>>(); //instantiere
        for(Object[] row : data) {
            Vector<Object> v=new Vector<Object>();
            Collections.addAll(v, row);
            rows.add(v);
        }
    }
    
    public void print(Printer printer) {
        printer.print(rows);
    }
    
    public class CsvPrinter implements Printer {
        private String delimiter;
    
        public CsvPrinter(String delimiter) {
            this.delimiter=delimiter;
        }
     
        public CsvPrinter() {
            this(",");
        }
        
        public void print(Vector<Vector<Object>> rows) {
            for(Vector<Object> row : rows) {
                if(row.size()==0) {
                    continue;
                }
                System.out.print(row.get(0));
                for(int i=1; i<row.size(); ++i) {
                    System.out.print(delimiter+row.get(i));
                }
                System.out.println();
            }
        }
    }
    
    class AsciiPrinter implements Printer {
        private final int[] limits;
        
        public AsciiPrinter(int[] limits) {
            this.limits=limits;
        }
        
        public void print(Vector<Vector<Object>> rows) {
            if(rows.size()==0) {
                return;
            }
            
            for(Vector<Object> row : rows) {
                int j=0;
                for(Object cell : row) {
                    System.out.format("%-"+limits[j++]+"s |", cell);
                }
                System.out.println();
            }
        }
    }
}