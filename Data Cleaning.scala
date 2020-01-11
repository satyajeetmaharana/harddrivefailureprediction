val df = sqlContext.read.format("com.databricks.spark.csv").option("header","true").load("/user/sm8235/harddrive_all_year/*.csv")

df.registerTempTable("HDD")

sqlContext.sql("""SELECT * FROM HDD WHERE date LIKE "date" """)



val df_new = sqlContext.sql("""SELECT date,serial_number,model,capacity_bytes,failure,smart_5_raw,smart_10_raw,smart_12_raw,smart_184_raw,smart_187_raw,smart_188_raw,smart_189_raw,smart_190_raw,smart_196_raw,smart_197_raw,smart_198_raw,smart_199_raw,smart_200_raw,smart_201_raw FROM HDD WHERE date NOT LIKE "date" """)


df_new.registerTempTable("HDD1")

val df_toshiba = sqlContext.sql("""SELECT * FROM HDD1 WHERE model LIKE "TOSHIBA%" """)


sqlContext.sql("""SELECT * FROM HDD1 WHERE model LIKE "TOSHIBA%" AND failure = "1" """).count()