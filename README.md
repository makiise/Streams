# Streams

#  Kutaisi International University assignment of Java Course
In this assignment, you should analyze a read data set by means of Streams. The given data set is a scientific freely available data set.

The template consists of the classes CSVReading with the method processInputFile which must return a Stream<PenguinData>, PenguinData corresponding to a particular data point, Penguin into which you later are meant to transform PenguinData, and Geo for the measured position.

We distinguish penguins according to the trackID of a data point, i.e., each penguin is uniquely identified by her trackID.

Methods:
 class CSVReading
Implement within the class CSVReading the method public static Stream<PenguinData> processInputFile() which reads the data from the OC_LPhillips_LittlePenguin_GPS_tracks_DATA.csv file (please, find the file in your clone or in online editor and note that you need to skip the first line) and returns a Stream<PenguinData>. In case the IOException ocures there, you must print: "Data Path seems to be wrong".

 toString for Penguins with Streams 
Implement within the class Penguin a method public String toStringUsingStreams() which returns the attributes of a single penguin in the followin format:
![image](https://user-images.githubusercontent.com/77580098/218207785-ec4a7f61-7977-49c9-a787-934d6e6d5c3d.png)

Thereby, the locations should be sorted before the output is produced where the values latitude should be compared first and only in case of equalites, the longitude values should be taken into account. As you see from the example output, both latitude as well as longitude is sorted in decreasing order.

We recommend to rely on the method toString from the class Geo, since it otherwise there could be problems with the number of digits in the mantissa.

 Locations pro Pinguin 
Implement within the class DataScience the method public static Stream<Penguin> getDataByTrackId(Stream<PenguinData> stream) which returns a stream of penguins. Thereby, all locations which agree in their TrackID should be combined into a single penguin. This penguin thus has a List<Geo> consisting of all these locations.

 Output for a Penguin
Implement a method public static void outputPenguinStream() which first outputs the number of penguins in the data set, and subsequenty each penguin in a separate line. Thereby, pengiuns are sorted according to their TrackID and should be output by means of the method toStringUsingStream(). If that method has not been implemented, the ordinary method toString can be used instead where, however, still the sorting should be according to the specification.

Important Remark for that sub-Task:

There are two tests here of which only one must be successful. Tese have not been combined into a single test, in order to provide a better error message. As long as one of the tests succeeds, no points will be deduced.

The output should in principle look as follows (the example exhibits only a prefix of the output):
![image](https://user-images.githubusercontent.com/77580098/218207981-60fb9078-2511-44c8-9740-a20ef65d5153.png)
 Min/Max/Avg Location per Penguin 
Implement a method public static void outputLocationRangePerTrackid(Stream<PenguinData> stream) which prints the respective minimum, maximum and average of longitude and latitude per TrackId in the following format. Again, the output is expected to be sorted according to the TrackIds.
![image](https://user-images.githubusercontent.com/77580098/218208064-5e25ae98-cb96-4b63-a2ab-acd03e8d47e4.png)
