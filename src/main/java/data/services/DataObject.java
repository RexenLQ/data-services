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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.HashMap;

public class DataObject
{

  public void assign(Object o)
  {
    HashMap<String, Method> target_methods = new HashMap<>();

    for (Method m : this.getClass().getMethods())
    {
      target_methods.put(m.getName(), m);
    }

    HashMap<String, Method> source_methods = new HashMap<>();

    for (Method m : o.getClass().getMethods())
    {
      source_methods.put(m.getName(), m);
    }

    for (String get_method_name : source_methods.keySet())
    {
      String set_method_name = null;

      if (get_method_name.substring(0, 3).equals("get"))
      {
        if (!get_method_name.equals("getId"))
        {
          Method get_method = source_methods.get(get_method_name);

          try
          {
            Object value = get_method.invoke(o, new Object[]
            {
            });

            set_method_name = "set" + get_method_name.substring(3, get_method_name.length());

            Method setter = target_methods.get(set_method_name);

            setter.invoke(this, new Object[]
            {
              value
            });
          }
          catch (Exception e)
          {
          }
        }
      }
    }
  }
}
