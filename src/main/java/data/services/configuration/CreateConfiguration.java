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

package data.services.configuration;

import data.services.configuration.FieldConfiguration;
import data.services.configuration.Configuration;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class CreateConfiguration
{

  public static void main(String args[]) throws JAXBException, FileNotFoundException
  {
    Configuration configuration = new Configuration();

    configuration.setEntityName("Account");
    configuration.setFileName("account.csv");
    configuration.setFields(new ArrayList<FieldConfiguration>());
    configuration.setExternalId("ExternalId");
    configuration.setBatchSize(1000);
    configuration.setDatabase("crm_mysql");

    FieldConfiguration fc = new FieldConfiguration();

    fc.setColumnName("Id");
    fc.setDataType("Integer");
    fc.setFieldName("Id");
    configuration.getFields().add(fc);

    FieldConfiguration fc2 = new FieldConfiguration();

    fc2.setColumnName("ExternalId");
    fc2.setDataType("Integer");
    fc2.setFieldName("ExternalId");
    configuration.getFields().add(fc2);

    FieldConfiguration fc3 = new FieldConfiguration();

    fc3.setColumnName("StartTime");
    fc3.setDataType("Date");
    fc3.setFieldName("StartTime");
    fc3.setFormat("YYYY-MM-DD");
    configuration.getFields().add(fc3);

    FieldConfiguration fc4 = new FieldConfiguration();

    fc4.setColumnName("Department");
    fc4.setDataType("Lookup");
    fc4.setFieldName("DepartmentId");
    fc4.setLookupEntityName("Department");
    fc4.setLookupFieldName("Name");
    fc4.setTargetFieldName("Id");
    fc4.setAutoReference(true);
    configuration.getFields().add(fc4);
    configuration.setDatabase("crm_mysql");
    configuration.setMax(1000000);
    configuration.setBatchSize(1000);

    File file = new File("configuration.xml");
    JAXBContext context = JAXBContext.newInstance(Configuration.class);
    Marshaller mrshaller = context.createMarshaller();

    mrshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    mrshaller.marshal(configuration, file);
    mrshaller.marshal(configuration, System.out);

    Unmarshaller unmarshaller = context.createUnmarshaller();

    configuration = (Configuration) unmarshaller.unmarshal(file);
    System.out.println(configuration.getFileName());
    System.out.println(configuration.getEntityName());

    for (FieldConfiguration f : configuration.getFields())
    {
      System.out.println(f.getColumnName());
      System.out.println(f.getFieldName());
      System.out.println(f.getDataType());
    }
  }
}


//~ Formatted by Jindent --- http://www.jindent.com
