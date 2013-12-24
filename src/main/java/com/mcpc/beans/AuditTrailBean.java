/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcpc.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ralf
 */
@Entity
@Table(name = "audit_trail")
@NamedQueries(
{
  @NamedQuery(name = "AuditTrailBean.findAll", query = "SELECT a FROM AuditTrailBean a")
})
public class AuditTrailBean implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "dbid")
  private Integer dbid;
  @Column(name = "created")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Column(name = "message")
  private String message;
  @Column(name = "module")
  private String module;
  @Column(name = "objectid")
  private String objectid;
  @Column(name = "operation")
  private String operation;
  @Column(name = "userid")
  private String userid;
  @Column(name = "username")
  private String username;

  public AuditTrailBean()
  {
  }

  public AuditTrailBean(Integer dbid)
  {
    this.dbid = dbid;
  }

  public Integer getDbid()
  {
    return dbid;
  }

  public void setDbid(Integer dbid)
  {
    this.dbid = dbid;
  }

  public Date getCreated()
  {
    return created;
  }

  public void setCreated(Date created)
  {
    this.created = created;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public String getModule()
  {
    return module;
  }

  public void setModule(String module)
  {
    this.module = module;
  }

  public String getObjectid()
  {
    return objectid;
  }

  public void setObjectid(String objectid)
  {
    this.objectid = objectid;
  }

  public String getOperation()
  {
    return operation;
  }

  public void setOperation(String operation)
  {
    this.operation = operation;
  }

  public String getUserid()
  {
    return userid;
  }

  public void setUserid(String userid)
  {
    this.userid = userid;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (dbid != null ? dbid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AuditTrailBean))
    {
      return false;
    }
    AuditTrailBean other = (AuditTrailBean) object;
    if ((this.dbid == null && other.dbid != null) || (this.dbid != null && !this.dbid.equals(other.dbid)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "com.mcpc.beans.AuditTrailBean[ dbid=" + dbid + " ]";
  }
  
}
