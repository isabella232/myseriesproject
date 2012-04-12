/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StatEpisodes.java
 *
 * Created on 28 Μαϊ 2010, 3:51:54 μμ
 */
package myseriesproject.statistics;

import database.DBConnection;
import database.SeriesRecord;
import java.awt.Color;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import myComponents.MyUsefulFunctions;
import myComponents.myTableCellRenderers.MyDecimalFormatRenderer;
import myseriesproject.MySeries;
import tools.MySeriesLogger;
import tools.options.MySeriesOptions;

/**
 *
 * @author ssoldatos
 */
public class StatEpisodes extends javax.swing.JPanel {

  private DefaultTableModel model;

  /** Creates new form StatEpisodes */
  public StatEpisodes() {
    initComponents();
    jScrollPane1.getViewport().setOpaque(false);
    model = (DefaultTableModel) table_stat_episodes.getModel();
    table_stat_episodes.getColumnModel().getColumn(2).setCellRenderer(new MyDecimalFormatRenderer());
    table_stat_episodes.getTableHeader().setReorderingAllowed(false);
    setVisible(true);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_stat_episodes = new javax.swing.JTable();
        lb_title = new javax.swing.JLabel();

        setOpaque(false);

        jScrollPane1.setOpaque(false);

        table_stat_episodes.setAutoCreateRowSorter(true);
        table_stat_episodes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Episode", "Series", "Rate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_stat_episodes.setName("episodesTable"); // NOI18N
        jScrollPane1.setViewportView(table_stat_episodes);

        lb_title.setFont(lb_title.getFont().deriveFont(lb_title.getFont().getStyle() | java.awt.Font.BOLD, lb_title.getFont().getSize()+2));
        lb_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_title.setText("Episodes Ratings");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(lb_title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_title;
    private javax.swing.JTable table_stat_episodes;
    // End of variables declaration//GEN-END:variables

  public void refresh() {
    clearModel();
    ResultSet rs = null;
    try {
      Statement stmt = DBConnection.conn.createStatement();
      String showDeleted = " ";
      if(MySeries.options.getBooleanOption(MySeriesOptions.HIDE_DELETED_SERIES_RATINGS)){
        showDeleted = "AND series.deleted = " + SeriesRecord.NOT_DELETED;
      }
      String sql = "SELECT  series.title AS series, episodes.episode as episode,  series.season as season, episodes.title as title, episodes.rate as rate "
          + "FROM series join episodes on series.series_ID = episodes.series_ID "
          + "where episodes.rate > 0 " + showDeleted + " order by rate desc";
      rs = stmt.executeQuery(sql);
      while (rs.next()) {
        String series = rs.getString("series") + " S" + MyUsefulFunctions.padLeft(rs.getInt("season"), 2, "0");
        String title = MyUsefulFunctions.padLeft(rs.getInt("episode"), 2, "0") + " - " + rs.getString("title");
        double rate = rs.getDouble("rate");
        Object[] data = {title, series, rate};
        model.addRow(data);
      }
      lb_title.setText("Episodes Ratings (" + model.getRowCount() + " episodes)");
    } catch (SQLException ex) {
    } finally {
      try {
        rs.close();
      } catch (SQLException ex) {
        MySeriesLogger.logger.log(Level.SEVERE, "Could not close resultset", ex);
      }
    }
  }

  private void clearModel() {
    for (int i = 0; i < model.getRowCount(); i++) {
      model.removeRow(i);
    }
  }

  public void setTextColor(Color color) {
    lb_title.setForeground(color);
  }
}
