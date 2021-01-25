/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AL_clases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HP
 */
public class ExportarExcel {
    
public void export() {
    
 
        String excelFilePath = "C:\\xampp\\tomcat\\webapps\\excel\\Reviews-export.xlsx";
 
        try {
            
            Connection conexion = null;
            PreparedStatement ps;
            String sql = "SELECT * FROM articulo";
            ConectaBD bd = new ConectaBD();
            bd.conecta();
            conexion=bd.getConexion();
            
            ps = conexion.prepareStatement(sql);
            
            ResultSet result = ps.executeQuery();
           
        
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Reviews");
 
            writeHeaderLine(sheet);
 
            writeDataLines(result, workbook, sheet);
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            
 
            ps.close();
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
 
    private void writeHeaderLine(XSSFSheet sheet) {
 
        Row headerRow = sheet.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Id Articulo");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Nombre");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Descripcion");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Precio");
 
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Stock");
        
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Imagen");
        
        
    }
 
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
 
        while (result.next()) {
            int id_articulo = result.getInt("id_articulo");
            String nombre = result.getString("nombre");
            String descripcion = result.getString("descripcion");
            double precio = result.getDouble("precio");
            int stock=result.getInt("stock");
            String imagen = result.getString("url_foto");
 
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id_articulo);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(nombre);
 
            cell = row.createCell(columnCount++);
 
            /*CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);*/
 
            cell.setCellValue(descripcion);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(precio);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(stock);
 
            cell = row.createCell(columnCount);
            cell.setCellValue(imagen);
 
        }
    }    
    
    
}
