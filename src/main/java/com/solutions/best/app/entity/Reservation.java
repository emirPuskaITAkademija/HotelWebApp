/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutions.best.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emir
 */
@Entity
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id"),
    @NamedQuery(name = "Reservation.findByCheckIn", query = "SELECT r FROM Reservation r WHERE r.checkIn = :checkIn"),
    @NamedQuery(name = "Reservation.findByCheckOut", query = "SELECT r FROM Reservation r WHERE r.checkOut = :checkOut"),
    @NamedQuery(name = "Reservation.findByFromDate", query = "SELECT r FROM Reservation r WHERE r.fromDate = :fromDate"),
    @NamedQuery(name = "Reservation.findByPrice", query = "SELECT r FROM Reservation r WHERE r.price = :price"),
    @NamedQuery(name = "Reservation.findByStatus", query = "SELECT r FROM Reservation r WHERE r.status = :status"),
    @NamedQuery(name = "Reservation.findByToDate", query = "SELECT r FROM Reservation r WHERE r.toDate = :toDate")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "check_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    @Column(name = "check_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    @Column(name = "from_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Column(name = "price")
    private BigInteger price;
    @Column(name = "status")
    private Short status;
    @Column(name = "to_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    @JoinColumn(name = "id_guest", referencedColumnName = "id")
    @ManyToOne
    private Guest idGuest;
    @JoinColumn(name = "id_room", referencedColumnName = "id")
    @ManyToOne
    private Room idRoom;

    public Reservation() {
    }

    public Reservation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Guest getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Guest idGuest) {
        this.idGuest = idGuest;
    }

    public Room getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Room idRoom) {
        this.idRoom = idRoom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.solutions.best.app.entity.Reservation[ id=" + id + " ]";
    }
    
}
