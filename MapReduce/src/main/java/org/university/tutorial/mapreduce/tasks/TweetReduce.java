/**
 * Simple Reducer for summarizing counts by the mapper
 */
package org.university.tutorial.mapreduce.tasks;

/**
* Author: Jörn Franke <jornfranke@gmail.com>
*
*/
import java.io.IOException;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
import java.util.*;

public class TweetReduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

   public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter)
     throws IOException {
       int sum = 0;
       while (values.hasNext()) {
           sum += values.next().get();
       }
       output.collect(key, new IntWritable(sum));
   }
}

