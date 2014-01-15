/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcpc.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "last_login_report")
@NamedQueries(
{
  @NamedQuery(name = "LastLoginReportBean.findAll", query = "SELECT l FROM LastLoginReportBean l")
})
public class LastLoginReportBean implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Column(name = "lastlogin")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastlogin;
  @Column(name = "fullname")
  private String fullname;
  @Id
  @Column(name = "externalsystemid")
  private String externalsystemid;
  @Column(name = "custompicklist0")
  private String custompicklist0;
  @Column(name = "custompicklist1")
  private String custompicklist1;
  @Column(name = "custompicklist2")
  private String custompicklist2;
  @Column(name = "managerfullname")
  private String managerfullname;

  public LastLoginReportBean()
  {
  }

  public Date getLastlogin()
  {
    return lastlogin;
  }

  public void setLastlogin(Date lastlogin)
  {
    this.lastlogin = lastlogin;
  }

  public String getFullname()
  {
    return fullname;
  }

  public void setFullname(String fullname)
  {
    this.fullname = fullname;
  }

  public String getExternalsystemid()
  {
    return externalsystemid;
  }

  public void setExternalsystemid(String externalsystemid)
  {
    this.externalsystemid = externalsystemid;
  }

  public String getCustompicklist0()
  {
    return custompicklist0;
  }

  public void setCustompicklist0(String custompicklist0)
  {
    this.custompicklist0 = custompicklist0;
  }

  public String getCustompicklist1()
  {
    return custompicklist1;
  }

  public void setCustompicklist1(String custompicklist1)
  {
    this.custompicklist1 = custompicklist1;
  }

  public String getCustompicklist2()
  {
    return custompicklist2;
  }

  public void setCustompicklist2(String custompicklist2)
  {
    this.custompicklist2 = custompicklist2;
  }

  public String getManagerfullname()
  {
    return managerfullname;
  }

  public void setManagerfullname(String managerfullname)
  {
    this.managerfullname = managerfullname;
  }
  
}
