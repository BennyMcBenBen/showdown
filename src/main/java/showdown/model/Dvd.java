/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package showdown.model;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * DVD POJO
 * @author Ben
 */
public class Dvd {

    private int id;
    private String title;
    private String description;
    private String image;
    private BigDecimal price;
    private Collection<Episode> episodes;

    public Dvd() {
    }

    public Dvd(String title, String description, String image, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Collection<Episode> episodes) {
        this.episodes = episodes;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
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
}
