/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtarea1;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author AntDVD
 */
public class ADTarea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        String reportSource = "./reports/templates/productos.jrxml";
        String reportDest = "./reports/results/productos.html";
        
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("reportTitle", "Listado de productos y costes de compra");
        params.put("author", "David Jiménez Riscardo");
        params.put("startDate", (new java.util.Date()).toString());
        
        try {
            
            JasperReport jr = JasperCompileManager.compileReport(reportSource);
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            java.sql.Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            
           
          
            JasperPrint jp = JasperFillManager.fillReport(jr, params, conn);
            
            JasperExportManager.exportReportToHtmlFile(jp, reportDest);
            
            JasperViewer.viewReport(jp);
            
        }catch (JRException ex){
            
            System.out.println(ex.getMessage());
        }
    }
    
}
