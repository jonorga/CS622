| CS-622       | Advanced Programming Techniques |
|--------------|---------------------------------|
| Name         | Jonathan Organ                  |
| Date         | 2/9/2024                        |
| Course       | Spring                          |
| Assignment # | 3                               |

# Assignment Overview
In this assignment the objective was implement a search history in our file merge and search program. 
Specifically, this search history should be able to add each searched term, and the time it was searched. I
decided to additionally make the search history persistant. 

# Required Components
- Add a search query
	* The SearchHistory class contains a method called addSearchQuery that is called every time the user
	searches for a term. It records the current time and saves that in a hashmap of all the queries
- Print all search queries
	* The SearchHistory class also contains the printSearchHistory method which prints out the total number
	of searches, total unique searches, and each individual search term along with all of their timestamps. 
- Extra areas
	* Outside of the main requirements, I also implemented methods to allow the search history to write itself 
	to disk after each search, and check for a previous search history on the disk when starting up. The
	search history is saved as a CSV file called "searchhistory.csv"
- Other notes
	* I used a smaller data file for the searches to show an accelerated form of the searching