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
 * SPARK-32956
 * @see <a href="https://issues.apache.org/jira/browse/SPARK-32956">SPARK-32956</a>
 */
object CsvSourceApp {
  
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName(this.getClass.getSimpleName)
      .master("local[2]").getOrCreate()
  
    val df = spark.read
      .format("csv")
      .option("header", "true")
      .load("sql/core/data/csv/test.csv")
    
    df.show()
  
    spark.close()
  }
  
}
