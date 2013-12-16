
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.services;

//~--- JDK imports ------------------------------------------------------------
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p/>
 *
 * @author Kamala
 */
@XmlRootElement(name = "Configuration")
public class Configuration
{

  private int max = 1000000;
  private ArrayList<FieldConfiguration> fields;
  private String fileName;
  private String entityName;
  private String externalId;
  private int batchSize;
  private String database;
  private String encoded;
  private String operation;

  @XmlElement(name = "FileName")
  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }

  @XmlElement(name = "EntityName")
  public String getEntityName()
  {
    return entityName;
  }

  public void setEntityName(String entityName)
  {
    this.entityName = entityName;
  }

  @XmlElement(name = "Fields")
  public ArrayList<FieldConfiguration> getFields()
  {
    return fields;
  }

  public void setFields(ArrayList<FieldConfiguration> fields)
  {
    this.fields = fields;
  }

  @XmlElement(name = "ExternalId")
  public String getExternalId()
  {
    return externalId;
  }

  public void setExternalId(String externalIdName)
  {
    this.externalId = externalIdName;
  }

  @XmlElement(name = "BatchSize")
  public int getBatchSize()
  {
    return batchSize;
  }

  public void setBatchSize(int batchSize)
  {
    this.batchSize = batchSize;
  }

  @XmlElement(name = "Database")
  public String getDatabase()
  {
    return database;
  }

  public void setDatabase(String database)
  {
    this.database = database;
  }

  @XmlElement(name = "Max")
  public int getMax()
  {
    return max;
  }

  public void setMax(int max)
  {
    this.max = max;
  }

  @XmlElement(name = "Encoded")
  public String getEncoded()
  {
    return encoded;
  }

  public void setEncoded(String encoded)
  {
    this.encoded = encoded;
  }

  @XmlElement(name = "Operation")
  public String getOperation()
  {
    return operation;
  }

  public void setOperation(String operation)
  {
    this.operation = operation;
  }
}


//~ Formatted by Jindent --- http://www.jindent.com
