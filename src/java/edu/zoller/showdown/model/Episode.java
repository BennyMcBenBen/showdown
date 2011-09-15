package edu.zoller.showdown.model;

import java.util.Calendar;

/**
 * Episode POJO
 * @author Ben Zoller
 */
public class Episode {

    private int id;
    private Show show;
    private int season;
    private int episode;
    private String title;
    private String description;
    private String image;
    private Calendar airdate;
    private String huluEmbed;

    public Episode() {
    }

    public Episode(Show show, int season, int episode, String title, String
            description, String image, Calendar airdate, String huluEmbed) {
        this.show = show;
        this.season = season;
        this.episode = episode;
        this.title = title;
        this.description = description;
        this.image = image;
        this.airdate = airdate;
        this.huluEmbed = huluEmbed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getAirdate() {
        return airdate;
    }

    public void setAirdate(Calendar airdate) {
        this.airdate = airdate;
    }

    public String getHuluEmbed() {
        return huluEmbed;
    }

    public void setHuluEmbed(String huluEmbed) {
        this.huluEmbed = huluEmbed;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Episode other = (Episode) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
