/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcpc.beans;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ralf
 */
@Entity
@Table(name = "audit_trail_report")
@NamedQueries(
{
  @NamedQuery(name = "AuditTrailReportBean.findAll", query = "SELECT a FROM AuditTrailReportBean a")
})
public class AuditTrailReportBean implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private String id;
  @Column(name = "ym")
  private String ym;
  @Column(name = "username")
  private String username;
  @Column(name = "count")
  private int count;
  @Column(name = "externalsystemid")
  private String externalsystemid;
  @Column(name = "custompicklist2")
  private String custompicklist2;
  @Column(name = "managerfullname")
  private String managerfullname;
  @Column(name = "item")
  private String item;

  public AuditTrailReportBean()
  {
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getYm()
  {
    return ym;
  }

  public void setYm(String ym)
  {
    this.ym = ym;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public int getCount()
  {
    return count;
  }

  public void setCount(int count)
  {
    this.count = count;
  }

  public String getExternalsystemid()
  {
    return externalsystemid;
  }

  public void setExternalsystemid(String externalsystemid)
  {
    this.externalsystemid = externalsystemid;
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

  public String getItem()
  {
    return item;
  }

  public void setItem(String item)
  {
    this.item = item;
  }
  
}
