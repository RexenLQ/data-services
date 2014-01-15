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

package data.services;

import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.jpa.JpaHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DataAccessObject
{
  private boolean transaction = true;
  private JpaEntityManager jpa;

  public DataAccessObject(String unitName) throws Exception
  {
    try
    {
      System.out.println("load database " + unitName + "...");
      jpa = JpaHelper.getEntityManager(Persistence.createEntityManagerFactory(unitName).createEntityManager());
      
      jpa.setFlushMode(FlushModeType.COMMIT);
    }
    catch (Exception e)
    {
      throw e;
    }
  }

  public void update(Object[] data, String[] keys)
    throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
           NoSuchMethodException, Exception
  {
    if ((data != null) && (data.length > 0))
    {
      try
      {
        start();

        for (Object o : data)
        {
          Object example = o.getClass().newInstance();

          this.copy(o, example, keys);

          DataObject entity = (DataObject) find(example);

          if (entity != null)
          {
            entity.assign(o);
            jpa.merge(entity);
            data = null;
          }
        }

        commit();
      }
      catch (Exception e)
      {
        rollback();

        throw e;
      }
    }
  }

  private void delete(Object[] data) throws Exception
  {
    if ((data != null) && (data.length > 0))
    {
      try
      {
        start();

        for (Object o : data)
        {
          jpa.remove(o);
        }

        commit();
      }
      catch (Exception e)
      {
        rollback();

        throw e;
      }
    }
  }

  public void delete(Object[] data, String[] keys) throws Exception
  {
    ArrayList<Object> buffer = new ArrayList<Object>();

    for (Object o : data)
    {
      Object sample = o.getClass().newInstance();

      copy(o, sample, keys);
      sample = find(sample);

      if (sample != null)
      {
        buffer.add(sample);
      }
    }

    delete(buffer.toArray());
  }

  public void append(Object[] data) throws Exception
  {
    if ((data != null) && (data.length > 0))
    {
      try
      {
        start();

        for (Object o : data)
        {
          jpa.persist(o);
        }

        commit();
      }
      catch (Exception e)
      {
        rollback();

        throw e;
      }
    }
  }

  public Object[] find(Object example, int count)
  {
    Query q = jpa.createQueryByExample(example);

    q.setMaxResults(count);

    List l = q.getResultList();

    if ((l != null) && (l.size() > 0))
    {
      return l.toArray();
    }
    else
    {
      return null;
    }
  }

  public Object find(Object example)
    throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
  {
    Object[] data = find(example, 1);

    if ((data != null) && (data.length > 0))
    {
      return data[0];
    }
    else
    {
      return null;
    }
  }

  public void merge(Object[] objects, String[] keys) throws Exception
  {
    if ((objects != null) && (objects.length > 0))
    {
      ArrayList<Object> buffer1 = new ArrayList<Object>();
      ArrayList<Object> buffer2 = new ArrayList<Object>();

      for (Object o : objects)
      {
        Object example = o.getClass().newInstance();

        copy(o, example, keys);

        if (find(example) != null)
        {
          buffer2.add(o);
        }
        else
        {
          buffer1.add(o);
        }
      }

      if (buffer1.size() > 0)
      {
        try
        {
          append(buffer1.toArray());
        }
        catch (Exception e)
        {
          throw e;
        }
      }

      if (buffer2.size() > 0)
      {
        try
        {
          update(buffer2.toArray(), keys);
        }
        catch (Exception e)
        {
          throw e;
        }
      }
    }
  }

  public void start()
  {
    if (!jpa.getTransaction().isActive())
    {
      jpa.getTransaction().begin();
    }
  }

  public void commit()
  {
    if (jpa.getTransaction().isActive())
    {
      jpa.getTransaction().commit();
    }
  }

  public void rollback()
  {
    if (jpa.getTransaction().isActive())
    {
      jpa.getTransaction().rollback();
    }
  }

  public void execute(String sql) throws Exception
  {
    start();

    try
    {
      Query q = jpa.createNativeQuery(sql);

      q.executeUpdate();
      commit();
    }
    catch (Exception e)
    {
      rollback();

      throw e;
    }
  }

  public void transaction(boolean auto)
  {
    this.transaction = auto;
  }

  private void copy(Object o1, Object o2, String[] properties)
    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    HashMap<String, Method> o1m = new HashMap<String, Method>();

    for (Method m : o1.getClass().getMethods())
    {
      o1m.put(m.getName(), m);
    }

    HashMap<String, Method> o2m = new HashMap<String, Method>();

    for (Method m : o2.getClass().getMethods())
    {
      o2m.put(m.getName(), m);
    }

    for (String property : properties)
    {
      String getterName = "get" + property;
      String setterName = "set" + property;

      try
      {
        Method getter = o1m.get(getterName);
        Object value = getter.invoke(o1, new Object[]
        {
        });
        Method setter = o2m.get(setterName);

        setter.invoke(o2, new Object[]
        {
          value
        });
      }
      catch (Exception e)
      {
        System.out.println("getter name: " + getterName);
        System.out.println("setter name: " + setterName);
        e.printStackTrace();
      }
    }    
  }
}


//~ Formatted by Jindent --- http://www.jindent.com
