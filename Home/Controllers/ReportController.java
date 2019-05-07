package Home.Controllers;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



public class ReportController implements Initializable {
	@FXML
	TextField BT,A;
	@FXML
	Pane BR,GR;
	@FXML
	StackPane Com,ComGen,Fail;
	@FXML
	ComboBox<String> cbSort;
	@FXML
	ComboBox<Number> cbNumber;
	int numRow = 1;

	@FXML
	TextField txtSearch;

	@FXML
	ImageView imgReturn;

	@FXML
	ImageView imgHome;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		BR.setVisible(false);
		Com.setVisible(false);
		Fail.setVisible(false);
		ComGen.setVisible(false);
		GR.setVisible(false);
		cbSort.getItems().clear();
		cbNumber.getItems().clear();
		cbNumber.getItems().addAll(
				10,50,100
		);
		cbNumber.setEditable(true);
		cbSort.getItems().addAll(
				"Book Title",
				"Author",
				"Number"
		);
		
	}

	//Book Request
	private void inputData(String BookTitle, String Author) throws IOException{
		File excelFile = new File("/home/fouriv/IdeaProjects/B/src/Home/database.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		if (!rowIterator.hasNext()) {
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell = row.createCell(3);
			cell.setCellValue(1);
		}
		else numRow = (int) sheet.getRow(0).getCell(3).getNumericCellValue();
		System.out.print(numRow);
		boolean found = false;
		while (rowIterator.hasNext()) {
			XSSFRow oldrow = (XSSFRow) rowIterator.next();
			Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = oldrow.cellIterator();
			XSSFCell oldcell = (XSSFCell) cellIterator.next();
			if (oldcell.getStringCellValue().compareTo(BookTitle) != 0) break;
			oldcell = (XSSFCell) cellIterator.next();
			if (oldcell.getStringCellValue().compareTo(Author) != 0)  break;
			oldcell = (XSSFCell) cellIterator.next();
			int num = (int)oldcell.getNumericCellValue();
			num++;
			oldcell.setCellValue(num);
			found = true;
		}
		if (!found) {
			System.out.println("not found");
			XSSFRow row;
			if (numRow > 1) row = sheet.createRow(numRow-1);
			else row = sheet.getRow(0);
			numRow++;
			sheet.getRow(0).getCell(3).setCellValue(numRow);
			XSSFCell cellBT = row.createCell(0);
			cellBT.setCellValue(BookTitle);
			XSSFCell cellA = row.createCell(1);
			cellA.setCellValue(Author);
			XSSFCell cellNum = row.createCell(2);
			cellNum.setCellValue(1);
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(excelFile);
		workbook.write(fos);
		fos.close();
		workbook.close();
	}
	public void btnSum(ActionEvent event) throws Exception {
		if (!BT.getText().isEmpty() && !A.getText().isEmpty()) {
			inputData(BT.getText(),A.getText());
			Com.setVisible(true);
			//System.out.println(BT.getText() + " " + A.getText());
		}
		else Fail.setVisible(true);
		BT.clear(); A.clear();
	}
	public void btnComSum(ActionEvent event) {
		Com.setVisible(false);
	}
	public void btnFailSum(ActionEvent event) {
		Fail.setVisible(false);
	}
	
	//Generate report
	private void format(Document report) throws Exception {
		String text1 = "Cong hoa Xa hoi Chu nghia Viet Nam";
		String text2 = "Doc lap - Tu do - Hanh phuc";
		
		Chunk chunk1 = new Chunk(text1);
		chunk1.setFont(new Font(Font.FontFamily.TIMES_ROMAN));
		Paragraph para1 = new Paragraph(chunk1);
		para1.setAlignment(Paragraph.ALIGN_CENTER);
		report.add(para1);
		
		Chunk chunk2 = new Chunk(text2);
		chunk2.setFont(new Font(Font.FontFamily.TIMES_ROMAN));
		Paragraph para2 = new Paragraph(chunk2);
		para2.setAlignment(Paragraph.ALIGN_CENTER);
		para2.setSpacingAfter(50);
		report.add(para2);
		
	}
	private void inputReport(Document report, XSSFRow row) throws DocumentException {
		Iterator<Cell> cellIterator = row.cellIterator();
		Paragraph para = new Paragraph();
		
		String BT = cellIterator.next().getStringCellValue();
		Chunk chunkBT = new Chunk(BT);
		chunkBT.setFont(new Font(Font.FontFamily.TIMES_ROMAN));
		para.add(Paragraph.ALIGN_LEFT,chunkBT);
		
		String A = cellIterator.next().getStringCellValue();
		Chunk chunkA = new Chunk(A);
		chunkA.setFont(new Font(Font.FontFamily.TIMES_ROMAN));
		para.add(Paragraph.ALIGN_CENTER,chunkA);
		
		int Num = (int) cellIterator.next().getNumericCellValue();
		Chunk chunkNum = new Chunk(Integer.toString(Num));
		chunkNum.setFont(new Font(Font.FontFamily.TIMES_ROMAN));
		para.add(Paragraph.ALIGN_RIGHT,chunkNum);
		
		report.add(para);
	}
	private void makeReport() throws IOException, Exception {
		File excelFile = new File("/home/fouriv/IdeaProjects/B/src/Home/database.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row>  rowIterator = sheet.iterator();
		
		Document report = new Document();
		PdfWriter.getInstance(report,new FileOutputStream("D:\\eclipse-workspace\\demov1\\src\\application\\Report.pdf"));
		report.open();
		format(report);
		PdfPTable table = new PdfPTable(2);
		PdfPCell tablecell;
		while(rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();
			inputReport(report,row);

			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				XSSFCell cell =  (XSSFCell) cellIterator.next();
				tablecell = new PdfPCell(new Phrase(cell.getStringCellValue()));
				table.addCell(tablecell);
			}

		}
		report.add(table);
		report.close();
		workbook.close();
		fis.close();
	}
	//Book Request
	public void btnBR(ActionEvent event) {
		BR.setVisible(true);
		GR.setVisible(false);
	}
	
	//Generate Report
	@FXML
	public void btnGR(ActionEvent event) {
		GR.setVisible(true);
	}

	@FXML
	public void btnG(ActionEvent event) throws IOException, Exception {
		makeReport();
		ComGen.setVisible(true);
	}

	@FXML
	public void btnComG(ActionEvent event) {
		ComGen.setVisible(false);
		GR.setVisible(false);
	}

	@FXML
	public void btnH(MouseEvent event) throws Exception {
		Button button = (Button) event.getSource();
		Stage stage=(Stage)button.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("../fxml/Mainpage.fxml"));/* Exception */
		Scene scene = new Scene(root, 900, 600);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	public void onbtnEnter(MouseEvent e) {
		Button button = (Button) e.getSource();
		button.setStyle("-fx-background-color: #009999");
	}


	@FXML
	public void onbtnLeave(MouseEvent e) {
		Button button = (Button) e.getSource();
		button.setStyle("-fx-background-color:  #0373BD");

	}
}