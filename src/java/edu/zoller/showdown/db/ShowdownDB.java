package edu.zoller.showdown.db;

import edu.zoller.showdown.model.Dvd;
import edu.zoller.showdown.model.Episode;
import edu.zoller.showdown.model.Show;
import edu.zoller.showdown.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Static database CRUD methods for the app.
 * @author Ben
 */
public class ShowdownDB {

    /**
     * Creates a show entry.
     * @param show show
     * @return result
     */
    public static int createShow(Show show) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "INSERT INTO showdown.show (show_title, show_description, " +
                "show_image, start_year, end_year) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, show.getTitle());
            ps.setString(2, show.getDescription());
            ps.setString(3, show.getImage());
            ps.setInt(4, show.getStartYear());
            ps.setInt(5, show.getEndYear());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Creates an episode entry.
     * @param episode episode
     * @return result
     */
    public static int createEpisode(Episode episode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "INSERT INTO showdown.episode (ep_title, show_id, " +
                "ep_description, ep_image, hulu_embed, season, airdate, episode) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, episode.getTitle());
            ps.setInt(2, episode.getShow().getId());
            ps.setString(3, episode.getDescription());
            ps.setString(4, episode.getImage());
            ps.setString(5, episode.getHuluEmbed());
            ps.setInt(6, episode.getSeason());
            ps.setDate(7, new Date(episode.getAirdate().getTime().getTime()));
            ps.setInt(8, episode.getEpisode());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Creates a DVD entry.
     * @param dvd dvd
     * @return result
     */
    public static int createDvd(Dvd dvd) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "INSERT INTO showdown.dvd (dvd_title, dvd_description, " +
                "dvd_image, price) VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dvd.getTitle());
            ps.setString(2, dvd.getDescription());
            ps.setString(3, dvd.getImage());
            ps.setBigDecimal(4, dvd.getPrice());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Creates a DVD episode entry.
     * @param dvd dvd
     * @param episode episode
     * @return result
     */
    public static int createDvdEpisode(Dvd dvd, Episode episode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "INSERT INTO showdown.dvd_episodes (dvd_id, episode_id) VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, dvd.getId());
            ps.setInt(2, episode.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Creates a shopping care item entry.
     * @param user user
     * @param dvdId dvd ID
     * @return result
     */
    public static int createCartItem(User user, int dvdId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "INSERT INTO showdown.shopping_cart (email, dvd_id) VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setInt(2, dvdId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Reads a show entry by ID.
     * @param id show ID
     * @return show entry
     */
    public static Show readShow(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query =
                "SELECT * FROM showdown.show where show_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Show show = new Show();
                show.setId(rs.getInt("show_id"));
                show.setTitle(rs.getString("show_title"));
                show.setDescription(rs.getString("show_description"));
                show.setImage(rs.getString("show_image"));
                show.setStartYear(rs.getInt("start_year"));
                show.setEndYear(rs.getInt("end_year"));
                return show;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Reads an episode entry by ID.
     * @param id episode ID
     * @return episode entry
     */
    public static Episode readEpisode(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query =
                "SELECT * FROM showdown.episode JOIN showdown.show ON " +
                "showdown.episode.show_id = showdown.show.show_id WHERE " +
                "episode_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Show show = new Show();
                show.setId(rs.getInt("show_id"));
                show.setTitle(rs.getString("show_title"));
                show.setDescription(rs.getString("show_description"));
                show.setImage(rs.getString("show_image"));
                show.setStartYear(rs.getInt("start_year"));
                show.setEndYear(rs.getInt("end_year"));

                Episode episode = new Episode();
                episode.setId(rs.getInt("episode_id"));
                episode.setShow(show);
                episode.setSeason(rs.getInt("season"));
                episode.setEpisode(rs.getInt("episode"));
                episode.setTitle(rs.getString("ep_title"));
                episode.setDescription(rs.getString("ep_description"));
                episode.setImage(rs.getString("ep_image"));
                Calendar airdate = Calendar.getInstance();
                airdate.setTime(rs.getDate("airdate"));
                episode.setAirdate(airdate);
                episode.setHuluEmbed(rs.getString("hulu_embed"));
                return episode;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Reads a DVD entry by ID.
     * @param id DVD ID
     * @return DVD entry
     */
    public static Dvd readDvd(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query =
                "SELECT * FROM showdown.dvd WHERE dvd_id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Dvd dvd = new Dvd();
                dvd.setId(rs.getInt("dvd_id"));
                dvd.setTitle(rs.getString("dvd_title"));
                dvd.setDescription(rs.getString("dvd_description"));
                dvd.setImage(rs.getString("dvd_image"));
                dvd.setPrice(rs.getBigDecimal("price"));
                Collection<Episode> episodes = readDvdEpisodes(id);
                dvd.setEpisodes(episodes);
                return dvd;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Reads episodes on a DVD.
     * @param dvdId DVD ID
     * @return DVD episodes
     */
    public static Collection<Episode> readDvdEpisodes(int dvdId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query =
                "SELECT * FROM showdown.dvd_episodes " +
                "JOIN showdown.dvd ON showdown.dvd_episodes.dvd_id = showdown.dvd.dvd_id " +
                "JOIN showdown.episode ON showdown.dvd_episodes.episode_id = showdown.episode.episode_id " +
                "JOIN showdown.show ON showdown.episode.show_id = showdown.show.show_id " +
                "WHERE dvd.dvd_id = ? " +
                "ORDER BY show_title, season, episode";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, dvdId);
            rs = ps.executeQuery();
            Collection<Episode> episodes = new LinkedList<Episode>();
            while (rs.next()) {
                Show show = new Show();
                show.setId(rs.getInt("show_id"));
                show.setTitle(rs.getString("show_title"));
                show.setDescription(rs.getString("show_description"));
                show.setImage(rs.getString("show_image"));
                show.setStartYear(rs.getInt("start_year"));
                show.setEndYear(rs.getInt("end_year"));

                Episode episode = new Episode();
                episode.setId(rs.getInt("episode_id"));
                episode.setShow(show);
                episode.setSeason(rs.getInt("season"));
                episode.setEpisode(rs.getInt("episode"));
                episode.setTitle(rs.getString("ep_title"));
                episode.setDescription(rs.getString("ep_description"));
                episode.setImage(rs.getString("ep_image"));
                Calendar airdate = Calendar.getInstance();
                airdate.setTime(rs.getDate("airdate"));
                episode.setAirdate(airdate);
                episode.setHuluEmbed(rs.getString("hulu_embed"));
                episodes.add(episode);
            }
            return episodes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Reads all episodes from a show.
     * @param showId show ID
     * @return show episodes
     */
    public static Collection<Episode> readShowEpisodes(int showId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query =
                "SELECT * FROM showdown.episode JOIN showdown.show ON " +
                "showdown.episode.show_id = showdown.show.show_id " +
                "WHERE showdown.episode.show_id = ? " +
                "ORDER BY season, episode";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, showId);
            rs = ps.executeQuery();
            Collection<Episode> episodes = new LinkedList<Episode>();
            while (rs.next()) {
                Show show = new Show();
                show.setId(rs.getInt("show_id"));
                show.setTitle(rs.getString("show_title"));
                show.setDescription(rs.getString("show_description"));
                show.setImage(rs.getString("show_image"));
                show.setStartYear(rs.getInt("start_year"));
                show.setEndYear(rs.getInt("end_year"));

                Episode episode = new Episode();
                episode.setId(rs.getInt("episode_id"));
                episode.setShow(show);
                episode.setSeason(rs.getInt("season"));
                episode.setEpisode(rs.getInt("episode"));
                episode.setTitle(rs.getString("ep_title"));
                episode.setDescription(rs.getString("ep_description"));
                episode.setImage(rs.getString("ep_image"));
                Calendar airdate = Calendar.getInstance();
                airdate.setTime(rs.getDate("airdate"));
                episode.setAirdate(airdate);
                episode.setHuluEmbed(rs.getString("hulu_embed"));
                episodes.add(episode);
            }
            return episodes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Reads all shows
     * @return show collection
     */
    public static Collection<Show> readAllShows() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM showdown.show ORDER BY show_title";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Collection<Show> shows = new LinkedList<Show>();
            while (rs.next()) {
                Show show = new Show();
                show.setId(rs.getInt("show_id"));
                show.setTitle(rs.getString("show_title"));
                show.setDescription(rs.getString("show_description"));
                show.setImage(rs.getString("show_image"));
                show.setStartYear(rs.getInt("start_year"));
                show.setEndYear(rs.getInt("end_year"));
                shows.add(show);
            }
            return shows;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Reads all episodes.
     * @return episode collection
     */
    public static Collection<Episode> readAllEpisodes() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query =
                "SELECT * FROM showdown.episode JOIN showdown.show ON " +
                "showdown.episode.show_id = showdown.show.show_id " +
                "ORDER BY show_title, season, episode";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Collection<Episode> episodes = new LinkedList<Episode>();
            while (rs.next()) {
                Show show = new Show();
                show.setId(rs.getInt("show_id"));
                show.setTitle(rs.getString("show_title"));
                show.setDescription(rs.getString("show_description"));
                show.setImage(rs.getString("show_image"));
                show.setStartYear(rs.getInt("start_year"));
                show.setEndYear(rs.getInt("end_year"));

                Episode episode = new Episode();
                episode.setId(rs.getInt("episode_id"));
                episode.setShow(show);
                episode.setSeason(rs.getInt("season"));
                episode.setEpisode(rs.getInt("episode"));
                episode.setTitle(rs.getString("ep_title"));
                episode.setDescription(rs.getString("ep_description"));
                episode.setImage(rs.getString("ep_image"));
                Calendar airdate = Calendar.getInstance();
                airdate.setTime(rs.getDate("airdate"));
                episode.setAirdate(airdate);
                episode.setHuluEmbed(rs.getString("hulu_embed"));
                episodes.add(episode);
            }
            return episodes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Reads all DVDs.
     * @return DVD collection
     */
    public static Collection<Dvd> readAllDvds() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query =
                "SELECT * FROM showdown.dvd";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Collection<Dvd> dvds = new LinkedList<Dvd>();
            while (rs.next()) {
                Dvd dvd = new Dvd();
                int dvdId = rs.getInt("dvd_id");
                dvd.setId(dvdId);
                dvd.setTitle(rs.getString("dvd_title"));
                dvd.setDescription(rs.getString("dvd_description"));
                dvd.setImage(rs.getString("dvd_image"));
                dvd.setPrice(rs.getBigDecimal("price"));
                Collection<Episode> episodes = readDvdEpisodes(dvdId);
                dvd.setEpisodes(episodes);
                dvds.add(dvd);
            }
            return dvds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Reads user entry by email.
     * @param email email address
     * @return user entry
     */
    public static User readUser(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query =
                "SELECT * FROM showdown.user where email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setEmail(rs.getString("email"));
                user.setNickname(rs.getString("nickname"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Reads the DVDs in a user's shopping cart.
     * @param user user
     * @return DVDs in user's shopping cart
     */
    public static Collection<Dvd> readShoppingCart(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query =
                "SELECT * FROM showdown.shopping_cart JOIN showdown.dvd " +
                "ON showdown.shopping_cart.dvd_id = showdown.dvd.dvd_id " +
                "WHERE email = ? " +
                "ORDER BY dvd_title";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            rs = ps.executeQuery();
            Collection<Dvd> dvds = new LinkedList<Dvd>();
            while (rs.next()) {
                Dvd dvd = new Dvd();
                int dvdId = rs.getInt("dvd_id");
                dvd.setId(dvdId);
                dvd.setTitle(rs.getString("dvd_title"));
                dvd.setDescription(rs.getString("dvd_description"));
                dvd.setImage(rs.getString("dvd_image"));
                dvd.setPrice(rs.getBigDecimal("price"));
                Collection<Episode> episodes = readDvdEpisodes(dvdId);
                dvd.setEpisodes(episodes);
                dvds.add(dvd);
            }
            return dvds;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Updates a show entry.
     * @param show show
     * @return result
     */
    public static int updateShow(Show show) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "UPDATE showdown.show SET show_title=?, show_description=?, " +
                "show_image=?, start_year=?, end_year=? " +
                "WHERE show_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, show.getTitle());
            ps.setString(2, show.getDescription());
            ps.setString(3, show.getImage());
            ps.setInt(4, show.getStartYear());
            ps.setInt(5, show.getEndYear());
            ps.setInt(6, show.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Updates an episode entry.
     * @param episode episode
     * @return result
     */
    public static int updateEpisode(Episode episode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "UPDATE showdown.episode SET ep_title=?, show_id=?, " +
                "ep_description=?, ep_image=?, hulu_embed=?, season=?, airdate=?, " +
                "episode=? WHERE episode_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, episode.getTitle());
            ps.setInt(2, episode.getShow().getId());
            ps.setString(3, episode.getDescription());
            ps.setString(4, episode.getImage());
            ps.setString(5, episode.getHuluEmbed());
            ps.setInt(6, episode.getSeason());
            ps.setDate(7, new Date(episode.getAirdate().getTime().getTime()));
            ps.setInt(8, episode.getEpisode());
            ps.setInt(9, episode.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Updates a DVD entry.
     * @param dvd dvd
     * @return result
     */
    public static int updateDvd(Dvd dvd) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "UPDATE showdown.dvd SET dvd_title=?, dvd_description=?, " +
                "dvd_image=?, price=? WHERE dvd_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, dvd.getTitle());
            ps.setString(2, dvd.getDescription());
            ps.setString(3, dvd.getImage());
            ps.setBigDecimal(4, dvd.getPrice());
            ps.setInt(5, dvd.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Deletes a show entry by ID.
     * @param id show ID
     * @return result
     */
    public static int deleteShow(int id) {
        deleteShowEpisodes(id);

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "DELETE FROM showdown.show WHERE show_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Deletes an episode entry by ID.
     * @param id episode ID
     * @return result
     */
    public static int deleteEpisode(int id) {
        deleteDvdEpisodesByEpisode(id);

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "DELETE FROM showdown.episode WHERE episode_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Deletes all episodes associated with a show.
     * @param showId show ID
     * @return result
     */
    public static int deleteShowEpisodes(int showId) {
        // delete dvd episodes
        Collection<Episode> episodes = readShowEpisodes(showId);
        for (Episode ep : episodes) {
            deleteDvdEpisodesByEpisode(ep.getId());
        }

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "DELETE FROM showdown.episode WHERE show_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, showId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Deletes a DVD by ID.
     * @param id DVD ID
     * @return result
     */
    public static int deleteDvd(int id) {
        // delete dvd episodes
        deleteDvdEpisodes(id);

        // delete dvd
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "DELETE FROM showdown.dvd WHERE dvd_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Removes an episode from a DVD.
     * @param episodeId episode ID
     * @return result
     */
    public static int deleteDvdEpisodesByEpisode(int episodeId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "DELETE FROM showdown.dvd_episodes WHERE episode_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, episodeId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Deletes all episodes on a DVD.
     * @param dvdId DVD ID
     * @return result
     */
    public static int deleteDvdEpisodes(int dvdId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "DELETE FROM showdown.dvd_episodes WHERE dvd_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, dvdId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Deletes a DVD from a user's shopping cart.
     * @param user user
     * @param dvdId DVD ID
     * @return result
     */
    public static int deleteCartItem(User user, int dvdId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "DELETE FROM showdown.shopping_cart WHERE email=? AND dvd_id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setInt(2, dvdId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     * Deletes all DVDs from a user's shopping cart.
     * @param user user
     * @return result
     */
    public static int deleteShoppingCart(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query =
                "DELETE FROM showdown.shopping_cart WHERE email=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
