/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RenameEpisodes.java
 *
 * Created on 21 Μαρ 2010, 10:25:47 πμ
 */
package tools.renaming;

import database.EpisodesRecord;
import database.SeriesRecord;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.table.TableModel;
import myComponents.MyDraggable;
import myComponents.MyRenameEpisodesTableModel;
import myComponents.MyUsefulFunctions;
import tools.options.Options;

/**
 *
 * @author lordovol
 */
public class RenameEpisodes extends MyDraggable {

  private static final long serialVersionUID = 35546363456L;
  MyRenameEpisodesTableModel renameEpisodesModel = new MyRenameEpisodesTableModel();
  private ArrayList<File> oldNames;
  private ArrayList<EpisodesRecord> newNames;
  private SeriesRecord series;
  private boolean checkAll = false;

  public RenameEpisodes(ArrayList<File> oldNames,
          ArrayList<EpisodesRecord> newNames, SeriesRecord series) {
    this.oldNames = oldNames;
    this.newNames = newNames;
    this.series = series;
    initComponents();
    createTableModel();
    setLocationRelativeTo(null);
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

    jTextField4 = new javax.swing.JTextField();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    button_rename = new javax.swing.JButton();
    button_cancel = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    table_rename = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    textfield_season = new javax.swing.JTextField();
    textfield_episode = new javax.swing.JTextField();
    textfield_title = new javax.swing.JTextField();
    button_apply = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    checkBox_checkAll = new javax.swing.JCheckBox();

    jTextField4.setText("jTextField4");

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Renaming episodes");

    button_rename.setText("Rename");
    button_rename.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_renameActionPerformed(evt);
      }
    });

    button_cancel.setText("Cancel");
    button_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_cancelActionPerformed(evt);
      }
    });

    table_rename.setModel(renameEpisodesModel);
    jScrollPane1.setViewportView(table_rename);

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setText("Separators :");

    jLabel3.setText("Season");

    jLabel4.setText("Episode");

    jLabel5.setText("Title");

    textfield_season.setText(Options.SEASON_SEPARATOR);

    textfield_episode.setText(Options.EPISODE_SEPARATOR);

    textfield_title.setText(Options.TITLE_SEPARATOR);

    button_apply.setText("Apply");
    button_apply.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_applyActionPerformed(evt);
      }
    });

    jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel6.setText("Check/Uncheck  all :");

    checkBox_checkAll.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkBox_checkAllActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(91, 91, 91)
            .addComponent(jLabel3))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(checkBox_checkAll)
              .addComponent(textfield_season, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addComponent(textfield_episode, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel5)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(textfield_title, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(button_apply)))
        .addGap(223, 223, 223))
    );

    jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textfield_episode, textfield_season, textfield_title});

    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap(27, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jLabel4)
          .addComponent(jLabel5))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(textfield_season, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(textfield_episode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(textfield_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(button_apply))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(checkBox_checkAll, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
            .addComponent(button_rename)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(button_cancel))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
          .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(button_rename)
          .addComponent(button_cancel))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
    myseries.MySeries.glassPane.deactivate();
    dispose();
  }//GEN-LAST:event_button_cancelActionPerformed

  private void button_applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_applyActionPerformed

    createTableModel();
  }//GEN-LAST:event_button_applyActionPerformed

  private void button_renameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_renameActionPerformed
    TableModel model = table_rename.getModel();
    int renames = 0;
    int fails = 0;
    for (int i = 0; i < model.getRowCount(); i++) {
      if (Boolean.parseBoolean(String.valueOf(model.getValueAt(i, 3)))) {
        File oldFile = new File(series.getLocalDir() + "/" + model.getValueAt(i, 1));
        File newFile = new File(series.getLocalDir() + "/" + model.getValueAt(i, 2));
        myseries.MySeries.logger.log(Level.INFO, "Renaming :" + oldFile + " to " + newFile);
        if (oldFile.renameTo(newFile)) {
          myseries.MySeries.logger.log(Level.INFO, "Renamed :" + oldFile + " to " + newFile);
          renames++;
        } else {
          myseries.MySeries.logger.log(Level.INFO, "Fail to rename :" + oldFile + " to " + newFile);
          fails++;
        }
      }
    }
    dispose();
    MyUsefulFunctions.message("Renaming episodes", renames + " episodes renamed and " + fails + " episodes failed");
  }//GEN-LAST:event_button_renameActionPerformed

  private void checkBox_checkAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBox_checkAllActionPerformed
    checkAll = checkBox_checkAll.isSelected();
    createTableModel();
  }//GEN-LAST:event_checkBox_checkAllActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton button_apply;
  private javax.swing.JButton button_cancel;
  private javax.swing.JButton button_rename;
  private javax.swing.JCheckBox checkBox_checkAll;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextField jTextField4;
  private javax.swing.JTable table_rename;
  private javax.swing.JTextField textfield_episode;
  private javax.swing.JTextField textfield_season;
  private javax.swing.JTextField textfield_title;
  // End of variables declaration//GEN-END:variables

  private void createTableModel() {
    renameEpisodesModel = new MyRenameEpisodesTableModel();
    renameEpisodesModel.addColumn("ID");
    renameEpisodesModel.addColumn("Old Name");
    renameEpisodesModel.addColumn("New Name");
    renameEpisodesModel.addColumn("Rename");
    table_rename.setModel(renameEpisodesModel);
    table_rename.getColumn("ID").setPreferredWidth(30);
    table_rename.getColumn("Old Name").setPreferredWidth(200);
    table_rename.getColumn("New Name").setPreferredWidth(200);
    table_rename.getColumn("Rename").setPreferredWidth(60);
    if (oldNames.size() != newNames.size()) {
      myseries.MySeries.logger.log(Level.WARNING, "An error occured, old names size != new names size");
      MyUsefulFunctions.error("Error", "An error occured, old names size != new names size");
      dispose();
    }
    for (int i = 0; i < oldNames.size(); i++) {

      File oldFile = oldNames.get(i);
      File newFile = createFile(newNames.get(i), oldFile);
      if (oldFile.equals(newFile)) {
        Object[] data = {i, oldFile.getName(), newFile.getName(), false};
        renameEpisodesModel.addRow(data);
      } else {
        Object[] data = {i, oldFile.getName(), newFile.getName(), checkAll};
        renameEpisodesModel.addRow(data);
      }
      
    }

  }

  private File createFile(EpisodesRecord episode, File oldFile) {
    String[] tokens = oldFile.getName().split("\\.", -1);
    String ext = tokens[tokens.length - 1];
    if (ext.equals("srt") || ext.equals("sub")) {
      if (tokens[tokens.length - 2].equals("gr") || tokens[tokens.length - 2].equals("en")) {
        ext = tokens[tokens.length - 2] + "." + tokens[tokens.length - 1];
      }
    }

    String newFilename = series.getTitle() + textfield_season.getText()
            + MyUsefulFunctions.padLeft(series.getSeason(), 2, "0")
            + textfield_episode.getText()
            + MyUsefulFunctions.padLeft(episode.getEpisode(), 2, "0")
            + textfield_title.getText() + episode.getTitle();

    String newName = series.getLocalDir() + "/" + newFilename + "." + ext;
    return new File(newName);
  }
}
