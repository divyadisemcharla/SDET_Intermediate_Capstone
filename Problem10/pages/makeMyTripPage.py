import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains

class MakeMyTripPage:
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)  
        self.action = ActionChains(driver)

    flights="//a[@href='https://www.makemytrip.com/flights/']"
    round_trip="//li[@data-cy='roundTrip']/span"
    from_city="//input[@id='fromCity']"
    to_city="//input[@id='toCity']"
    fromcity_name1="Hyderabad"
    fromcity_results="(//li[@role='option'])[1]"
    city_name2="MAA"
    search_button="//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"
    flight_results="//p[@class='font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom']"
    

    def select_from_city(self):  
        self.action.move_by_offset(0, 0) #clicking anywhere outside to avoid the login frame
        self.action.click()
        self.action.perform()
        # Find and click on the Flights option      
        self.driver.find_element(By.XPATH,self.flights).click()
        # Find and click on the Round Trip option
        self.wait.until(EC.presence_of_element_located((By.XPATH,self.round_trip)))
        self.driver.find_element(By.XPATH,self.round_trip).click()
        # Find and click on the "From" city input field
        self.wait.until(EC.presence_of_element_located((By.XPATH,self.from_city)))
        ClickfromCity = self.driver.find_element(By.ID, 'fromCity')
        ClickfromCity.click()
        self.action.send_keys(self.fromcity_name1)
        self.action.perform()
        self.wait.until(EC.presence_of_element_located((By.XPATH,self.fromcity_results)))
        results1=self.driver.find_element(By.XPATH,self.fromcity_results)
        time.sleep(2) # Sleep for a while to observe the results
        results1.click()
 
    def select_to_city(self):       
		# Find and click on the "To" city input field
        self.wait.until(EC.presence_of_element_located((By.XPATH,self.to_city)))
        ClickToCity = self.driver.find_element(By.ID, 'toCity')
        ClickToCity.click()
        self.action.send_keys(self.city_name2)
        self.action.perform()
        self.wait.until(EC.presence_of_element_located((By.XPATH,self.fromcity_results)))
        results2=self.driver.find_element(By.XPATH,self.fromcity_results)
        time.sleep(2) # Sleep for a while to observe the results
        results2.click()

    def select_dates(self):
        time.sleep(3)
        self.action.move_by_offset(0, 0) #clicking anywhere outside in the page as the current dates are selected default
        self.action.click()
        self.action.perform()
        self.wait.until(EC.presence_of_element_located((By.XPATH,self.search_button)))

    def verify_searchpage(self):           
        # Find and click on the "Search" button       
        search=self.driver.find_element(By.XPATH,self.search_button)
        search.click()
        self.wait.until(EC.presence_of_element_located((By.XPATH,self.flight_results)))
		# Verifying the search page is displayed    
        searchPage=self.driver.find_element(By.XPATH,self.flight_results)        
        searchPage.is_displayed()
