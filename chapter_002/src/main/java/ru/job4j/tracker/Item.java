package ru.job4j.tracker;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table (name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    private Timestamp createTime;
    private Timestamp closeTime;
    private Integer userId;
    private String category;
    private String status;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, Integer userId, String category) {
        this.name = name;
        this.userId = userId;
        this.category = category;
    }

    public Item() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(id, item.id)
                && Objects.equals(name, item.name)
                && Objects.equals(createTime, item.createTime)
                && Objects.equals(closeTime, item.closeTime)
                && Objects.equals(userId, item.userId)
                && Objects.equals(category, item.category)
                && Objects.equals(status, item.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createTime, closeTime, userId, category, status);
    }
}
