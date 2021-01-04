import pandas as pd
from glob import glob


def get_local_files() -> list:
    local_files = glob("*.csv")
    return local_files


def files_to_data_frames(local_files: list) -> list:
    data_frames = []
    for local_file in local_files:
        df = pd.read_csv(local_file)
        data_frames.append(df)
        del df
    return data_frames


def one_giant_data_frame(data_frames: list) -> pd.DataFrame:
    big_un = pd.concat(data_frames, copy=False)
    return big_un


if __name__ == "__main__":
    local_files = get_local_files()
    data_frames = files_to_data_frames(local_files)
    big_un = one_giant_data_frame(data_frames)
    print(len(big_un.index))
    big_un.to_csv("one_giant_file.csv")
