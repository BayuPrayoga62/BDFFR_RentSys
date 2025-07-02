package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class resultsettable extends AbstractTableModel {
    private ResultSet rs;
    private int rowCount;

//    public resultsettable(ResultSet rs) {
//        this.rs = rs;
//        try {
//            // Hitung jumlah baris saat inisialisasi
//            rs.last();
//            rowCount = rs.getRow();
//            rs.beforeFirst(); // Kembali ke awal setelah menghitung
//        } catch (SQLException e) {
//            System.out.println("Error while initializing ResultSetTableModel");
//            e.printStackTrace();
//            rowCount = 0; // Set rowCount ke 0 jika ada kesalahan
//        }
//    }
    
    public resultsettable(ResultSet rs) {
    this.rs = rs;
    if (rs == null) {
        System.out.println("ResultSet is null in resultsettable constructor");
        rowCount = 0;
        return;
    }
    try {
        rs.last();
        rowCount = rs.getRow();
        rs.beforeFirst();
    } catch (SQLException e) {
        System.out.println("Error while initializing ResultSetTableModel");
        e.printStackTrace();
        rowCount = 0;
    }
}


    @Override
    public int getColumnCount() {
        try {
            if (rs == null) {
                return 0;
            } else {
                return rs.getMetaData().getColumnCount();
            }
        } catch (SQLException e) {
            System.out.println("Error while getting column count");
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getRowCount() {
        return rowCount; // Kembalikan nilai yang sudah dihitung
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    try {
        if (rs == null || rowCount == 0 || rowIndex >= rowCount) {
            return null;
        }
        rs.absolute(rowIndex + 1);
        return rs.getObject(columnIndex + 1);
    } catch (SQLException e) {
        System.out.println("Error while fetching row data");
        e.printStackTrace();
        return null;
    }
}
    
    
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        if (rowIndex < 0 || rowIndex >= getRowCount() || columnIndex < 0 || columnIndex >= getColumnCount()) {
//            return null;
//        }
//        try {
//            if (rs == null) {
//                return null;
//            } else {
//                rs.absolute(rowIndex + 1); // Pindah ke baris yang sesuai
//                return rs.getObject(columnIndex + 1);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error while fetching row data");
//            e.printStackTrace();
//            return null;
//        }
//    }

    @Override
    public String getColumnName(int columnIndex) {
        try {
            return rs.getMetaData().getColumnName(columnIndex + 1);
        } catch (SQLException e) {
            System.out.println("Error while fetching column name");
            e.printStackTrace();
            return super.getColumnName(columnIndex);
        }
    }
}

//package database;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.swing.table.AbstractTableModel;
//
//public class resultsettable extends AbstractTableModel {
//private ResultSet rs;
//    
//    public resultsettable(ResultSet rs) {
//        this.rs = rs;
//    }
//
//    public int getColumnCount() {
//     try {
//      if (rs == null) {
//       return 0;
//      } 
//      else {
//       return rs.getMetaData().getColumnCount();
//      }
//     } 
//     catch (SQLException e) {
//      System.out.println("resultset generating error while getting column count");
//      System.out.println(e.getMessage());
//      return 0;
//     }
//    }
//
//    public int getRowCount() {
//        try {
//         if (rs == null) {
//         return 0;
//        } 
//        else {
//         rs.last();
//         return rs.getRow();
//        }
//        } 
//        catch (SQLException e) {
//         System.out.println("resultset generating error while getting rows count");
//         System.out.println(e.getMessage());
//         return 0;
//        }
//    }
//
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        if (rowIndex < 0 || rowIndex > getRowCount()
//                || columnIndex < 0 || columnIndex > getColumnCount()) {
//            return null;
//        }
//        try {
//            if (rs == null) {
//                return null;
//            } else {
//                rs.absolute(rowIndex + 1);
//                return rs.getObject(columnIndex + 1);
//            }
//        } catch (SQLException e) {
//            System.out.println("resultset generating error while fetching rows");
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//    @Override
//    public String getColumnName(int columnIndex) {
//     try {
//      return rs.getMetaData().getColumnName(columnIndex + 1);
//     } 
//     catch (SQLException e) {
//      System.out.println("resultset generating error while fetching column name");
//      System.out.println(e.getMessage());
//     }
//     return super.getColumnName(columnIndex);
//    }
//}