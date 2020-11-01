/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lsk.spark.sql

import org.apache.spark.sql.SparkSession

/**
 * TODO: 
 *
 * @author red
 * @class_name ExampleApp01
 * @date 2020-10-30
 */
object ExampleApp01 {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName(this.getClass.getSimpleName)
      .master("local[2]").getOrCreate()

    val df = spark.read.format("json").load("sql/core/data/json/student.json")

    df.createOrReplaceTempView("student")

    val frame = spark.sql("select name from student where age > 18")

//    println(frame.queryExecution.logical)

    frame.show()


  }

}
