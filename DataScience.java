package pgdp.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.Comparator;

public class DataScience {
  public static Stream<Penguin> getDataByTrackId(Stream<PenguinData> stream) {
    return stream
        .collect(Collectors.groupingBy(PenguinData::getTrackID))
        .entrySet()
        .stream()
        .map(x -> new Penguin(
            x.getValue()
             .stream()
             .map(PenguinData::getGeom)
             .collect(Collectors.toList()),
            x.getKey()
        ));
  }

  public static void outputPenguinStream() {
    System.out.println(getDataByTrackId(CSVReading.processInputFile()).count());
    DataScience.getDataByTrackId(CSVReading.processInputFile()).sorted(Comparator.comparing(Penguin::getTrackID))
        .forEach(x -> System.out.println(x.toStringUsingStreams()));
  }

  public static void outputLocationRangePerTrackid(Stream<PenguinData> stream) {
    DataScience.getDataByTrackId(stream)
      .sorted(Comparator.comparing(Penguin::getTrackID).reversed())
      .forEach(p -> {
        System.out.println(p.getTrackID());
        
        List<Double> longtitudes = p
          .getLocations()
          .stream()
          .map(x -> x.getLongitude())
          .collect(Collectors.toList());
          
        List<Double> latitudes = p
          .getLocations()
          .stream()
          .map(x -> x.getLatitude())
          .collect(Collectors.toList());
        
        System.out.println(
          "Min Longitude: " + longtitudes.stream().mapToDouble(x -> x).min().getAsDouble() + " " +
          "Max Longitude: " + longtitudes.stream().mapToDouble(x -> x).max().getAsDouble() + " " +
          "Avg Longitude: " + longtitudes.stream().mapToDouble(x -> x).average().getAsDouble() + " " +
          "Min Latitude: " + latitudes.stream().mapToDouble(x -> x).min().getAsDouble() + " " +
          "Max Latitude: " + latitudes.stream().mapToDouble(x -> x).max().getAsDouble() + " " +
          "Avg Latitude: " + latitudes.stream().mapToDouble(x -> x).average().getAsDouble()
        );
      });
  
  }

  public static void main(String[] args) {
    // TODO Test your implementation yourself
  }
}
