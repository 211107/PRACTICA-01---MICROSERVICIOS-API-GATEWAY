from sqlalchemy import create_engine
from sqlalchemy.orm import declarative_base
from sqlalchemy.orm import sessionmaker
from dotenv import load_dotenv
import os

load_dotenv()

user = os.getenv('DBUSER')
password = os.getenv('DBPASS')
url = os.getenv('DBURL')
name = os.getenv('DBNAME')

Base = declarative_base()

DATABASE_URL = f'mysql+pymysql://{user}:{password}@{url}/{name}'

engine = create_engine(DATABASE_URL)
Base.metadata.create_all(bind=engine)
session_local = sessionmaker(bind=engine)
