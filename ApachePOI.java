import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ApachePOI {

    @Test
    public void testApachePoi() {

        try {
            FileInputStream fis =
                    new FileInputStream("src\\main\\resources\\fajlzaTestiranje.xlsx"); //reltivna putanja OD korena (root-a) projekta - nedelja7
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet list = workbook.getSheetAt(0); // prvi list
            /*XSSFRow red = list.getRow(0); // prvi red
            XSSFCell kockicka = red.getCell(0); // prva kolona
            String vrednost = kockicka.getStringCellValue();
            System.out.println("Vrednost: " + vrednost);

            XSSFCell kockicka2 = red.getCell(1);
            System.out.println("Vrednost: " + kockicka2.getStringCellValue());

            XSSFCell kockicka3 = red.getCell(2);
            System.out.println("Vrednost: " + kockicka3.getStringCellValue());*/
            for (int i = 1; i <= list.getLastRowNum(); i++) {
                XSSFRow r = list.getRow(i); // i-ti red
                for (int j = 0; j < r.getLastCellNum(); j++) { //ako dodamo = onda izbacuje null
//                    System.out.println(r.getLastCellNum());
//                    System.out.println();
                    XSSFCell cell = r.getCell(j);
                    System.out.print(cell.getStringCellValue() + " ");
                }
                System.out.println();
            }


        } catch (FileNotFoundException e) {
            System.out.println("Fail nije nadjen");
            e.printStackTrace(); // zaustavlja izvrsavanje programa (status code 1) i stampa trag poziva metoda (stack trace)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
