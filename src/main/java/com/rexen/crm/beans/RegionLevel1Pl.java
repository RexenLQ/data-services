/*
 * Copyright 2013 Ralf.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rexen.crm.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Ralf
 */
@Entity
@Table(name = "region_level1_pl")
@NamedQueries(
  {
    @NamedQuery(name = "RegionLevel1Pl.findAll", query = "SELECT r FROM RegionLevel1Pl r")
  })
public class RegionLevel1Pl implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private int    id;
  @Column(name = "val")
  private String val;

  public RegionLevel1Pl()
  {
  }

  public RegionLevel1Pl(int id)
  {
    this.id = id;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getVal()
  {
    return val;
  }

  public void setVal(String val)
  {
    this.val = val;
  }

}
