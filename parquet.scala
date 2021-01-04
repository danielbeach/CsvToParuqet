import com.github.tototoshi.csv._

import com.github.mjakubowski84.parquet4s.{ParquetWriter}

object parquet extends App {
  case class Record(ride_id: String, rideable_type : String,
                    started_at : String, ended_at : String,
                    start_station_name : String, start_station_id : String,
                    end_station_name : String, end_station_id : String,
                    start_lat : String, start_lng : String,
                    end_lat : String, end_lng : String,
                    member_casual : String
  )

  def csv_iterator(): Iterator[Seq[String]] = {
    val reader = CSVReader.open("src/main/scala/one_giant_file.csv")
    val csv_rows = reader.iterator
    csv_rows
  }

  val t1 = System.nanoTime
  val rows = csv_iterator()
  val records : Iterator[Record] = rows.map(row => Record(row(0),row(1),row(2),row(3),row(4),row(5),row(6),row(7),row(8),row(9),row(10),row(11),row(12) ))
  val values = records.toList
  ParquetWriter.writeAndClose("src/main/scala/data.parquet", values)
  val duration = (System.nanoTime - t1) / 1e9d
  println(duration)
}