import pytest
from selenium import webdriver
from pages import MakeMyTripPage

@pytest.fixture(scope="module")
def driver_init():
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get("https://www.makemytrip.com/")
    yield driver
    # driver.quit()

@pytest.mark.usefixtures("driver_init")
class TestMakeMyTrip:
    def test_MakeMyTrip_scenario(self,driver_init):
        page = MakeMyTripPage(driver_init)
        page.select_from_city()
        page.select_to_city()
        page.select_dates()
        page.verify_searchpage()





