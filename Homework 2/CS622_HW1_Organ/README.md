| CS-622       | Advanced Programming Techniques |
|--------------|---------------------------------|
| Name         | Jonathan Organ                  |
| Date         | 2/5/2024                        |
| Course       | Spring                          |
| Assignment # | 2                               |

# Assignment Overview
In this assignment the objective was to create a program to merge a large number of files, then be
able to search the merged file for a given keyword, and return certain data points from where it 
was found.

# Required Components
- Merging files
	* The MergeFile class merges each file one by one, filtering their input to remove any invalid
	rows and writing the result back to the disk. 
- Searching for a keyword
	* The SearchMaster class takes a given keyword and uses a regular expression to find any line
	in which that keyword appears. It then parses that line for the needed data, prints it to the
	console, and continues searching the rest of the file.
- Extra areas
	* Outside of the main requirements. I also implemented a small user interface to allow for easy
	testing of the program. The UI also includes the ability to specify alternative data directories,
	or terms to search for.