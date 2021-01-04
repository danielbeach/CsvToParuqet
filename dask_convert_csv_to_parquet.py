from dask.dataframe import read_csv
from datetime import datetime


def file_to_data_frame_to_parquet(local_file: str, parquet_file: str) -> None:
    dask_df = read_csv(local_file)
    dask_df.to_parquet(parquet_file)


if __name__ == "__main__":
    local_csv_file = "one_giant_file.csv"
    t1 = datetime.now()
    file_to_data_frame_to_parquet(local_csv_file, "my_parquet.parquet")
    t2 = datetime.now()
    took = t2 - t1
    print(f"it took {took} seconds to write csv to parquet.")
