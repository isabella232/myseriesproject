/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myseries.actions;

import database.DBHelper;
import database.SeriesRecord;
import help.About;
import help.CheckUpdate;
import help.Help;
import java.awt.Desktop;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableColumnModel;
import myComponents.MyMessages;
import myComponents.MyUsefulFunctions;
import myseries.MySeries;
import myseries.episodes.Episodes;
import myseries.filters.Filters;
import myseries.series.RestoreSeries;
import myseries.series.Series;
import tools.download.torrents.TorrentConstants;
import tools.internetUpdate.tvrage.TrGetId;
import tools.options.Options;
import tools.options.OptionsPanel;

/**
 *
 * @author ssoldatos
 */
public class ApplicationActions {

  public static void showOptions(MySeries m) {
    MySeries.glassPane.activate(null);
    OptionsPanel a = new OptionsPanel(m);
  }

  public static void exitApplication(MySeries m) {
    int divLocation = MySeries.splitPane_main.getDividerLocation();
    Options.setOption(Options.DIVIDER_LOCATION, divLocation);
    int feedDivLocation = MySeries.feedSplitPanel.getDividerLocation();
    Options.setOption(Options.FEED_DIVIDER_LOCATION, feedDivLocation);
    Options.setOption(Options.WINDOW_STATE, m.getExtendedState());
    Options.setOption(Options.WIDTH, m.getWidth());
    Options.setOption(Options.HEIGHT, m.getHeight());
    Options.setOption(Options.TOOLBAR_POSITION, m.getToolbarPosition());
    ArrayList<Integer> w = getTablesWidths(m);
    Options.setOption(Options.TABLE_WIDTHS, w);
    MySeries.logger.log(Level.INFO, "Saving options");
    Options.save();
    MySeries.logger.log(Level.INFO, "Application exiting...");
    System.exit(0);
  }

  private static ArrayList<Integer> getTablesWidths(MySeries m) {
    ArrayList<Integer> widths = new ArrayList<Integer>();
    TableColumnModel ts = MySeries.tableSeries.getColumnModel();
    for (int i = 0; i < ts.getColumnCount(); i++) {
      widths.add(ts.getColumn(i).getWidth());
    }
    ts = MySeries.tableEpisodes.getColumnModel();
    for (int i = 0; i < ts.getColumnCount(); i++) {
      widths.add(ts.getColumn(i).getWidth());
    }
    ts = MySeries.tableFilters.getColumnModel();
    for (int i = 0; i < ts.getColumnCount(); i++) {
      widths.add(ts.getColumn(i).getWidth());
    }

    return widths;
  }

  public static void about(MySeries m) {
    MySeries.glassPane.activate(null);
    About a = new About(m);
  }

  public static void checkUpdates() {
    MySeries.glassPane.activate(null);
    new CheckUpdate(false);
  }

  public static void clearLogFiles() {
    File dir = new File(Options._USER_DIR_);
    File[] files = dir.listFiles(new FilenameFilter() {

      @Override
      public boolean accept(File dir, String name) {
        if (name.matches("MySeriesLogs_([1-9]\\.html$|[0-9]\\.html\\.\\d+)")) {
          return true;
        }
        return false;
      }
    });
    if (files.length == 0) {
      MyMessages.message("Delete log files", "There are no old log files to delete");
      return;
    }
    int ans = MyMessages.question("Delete log files",
        "Realy delete the following " + files.length + " log files:\n"
        + MyUsefulFunctions.listAray(files, true));
    if (ans == JOptionPane.YES_OPTION) {
      for (int i = 0; i < files.length; i++) {
        File file = files[i];
        file.delete();
      }

    }
  }

  public static void viewLog(MySeries m) {
    Desktop d = Desktop.getDesktop();
    if (!Desktop.isDesktopSupported()) {
      MyMessages.error("Sorry!!!", "Your OS does not support this function");
    } else {
      if (!d.isSupported(Desktop.Action.OPEN)) {
        MyMessages.error("Sorry!!!", "Your OS does not support this function");
      } else {
        try {
          d.open(new File("MySeriesLogs_0.html"));
        } catch (IOException ex) {
          MySeries.logger.log(Level.SEVERE, "Could not read the log file", ex);
          MyMessages.error("View Log", "Couldn't find the log file");
        }
      }
    }
  }

  public static void changeTab(MySeries m, ChangeEvent evt) {
    Vector<SeriesRecord> series = null;
    JTabbedPane tabs = (JTabbedPane) evt.getSource();
    int index = tabs.getSelectedIndex();
    try {
      if (index == MySeries.TABS_PANEL_EPISODES) {
      } else if (index == MySeries.TABS_PANEL_FILTERS) {
        Filters.getFilteredSeries();
      } else if (index == MySeries.TABS_PANEL_RATINGS) {
        MySeries.statSeries.refresh(Options.toBoolean(Options.UNIFIED_SERIES));
        MySeries.statEpisodes.refresh();
      } else if (index == MySeries.TABS_PANEL_SCHEDULE) {
        //MySeries.scheduler.refreshCalendar(MySeries.scheduler.getRealMonth(),MySeries.scheduler.getRealYear());
      }

    } catch (SQLException ex) {
      MySeries.logger.log(Level.SEVERE, null, ex);
    }
  }

  public static void downloadScreenshot() {
    SeriesRecord series = Series.getCurrentSerial();
    if (series.getTvrage_ID() == 0) {
      TrGetId tr = new TrGetId(null, series.getSeries_ID(), series.getFullTitle());
    }
  }

  public static void restoreSeries() {
    try {
      ArrayList<SeriesRecord> series = Series.getSeries(true);

      if (series.isEmpty()) {
        MyMessages.message("Restore Series", "There are no deleted series to restore");
      } else {
        new RestoreSeries(series);
      }
    } catch (SQLException ex) {
      myseries.MySeries.logger.log(Level.SEVERE, null, ex);
    }
  }

  public static void showHelp(MySeries m) {
    if (!MySeries.isHelp) {
      new Help(m);
    }
  }

  public static void deleteTorrents() {
    if (MyMessages.question("Delete torrents", "Do you really want to clear the torrents directory?") == JOptionPane.OK_OPTION) {
      File dir = new File(Options._USER_DIR_ + TorrentConstants.TORRENTS_PATH);
      if (dir.isDirectory()) {
        File[] torrents = dir.listFiles();
        int del = 0, notDel = 0;
        if(torrents.length==0){
          MyMessages.message("Delete torrents", "There are no torrents to delete");
          return;
        }
        for (int i = 0; i < torrents.length; i++) {
          File tor = torrents[i];
          myseries.MySeries.logger.log(Level.INFO, "Deleting torrent {0}", tor.getName());
          if (tor.delete()) {
            del++;
            myseries.MySeries.logger.log(Level.FINE, "Torrent {0} deleted", tor.getName());
          } else {
            notDel++;
            myseries.MySeries.logger.log(Level.WARNING, "Torrent {0} could not be deleted", tor.getName());
          }
        }
        MyMessages.message("Delete torrents", del + " torrents deleted and " + notDel + "  torrents could not be deleted");
      } else {
        MyMessages.error("Delete torrents", "The torrents directory does not exist");
      }
    }
  }
}
