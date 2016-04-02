
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object kmeans {
	def main(args: Array[String]) {
		// Load and parse the data
	  val conf = new SparkConf().setAppName("Kmeans").setMaster("local")
    val sc = new SparkContext(conf)
		val data = sc.textFile("data/kmeans_data.txt")
		val parsedData = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble))).cache()

		// Cluster the data into two classes using KMeans
		val numClusters = 2
		val numIterations = 20
		val clusters = KMeans.train(parsedData, numClusters, numIterations)

		// Evaluate clustering by computing Within Set Sum of Squared Errors
		val WSSSE = clusters.computeCost(parsedData)
		println("Within Set Sum of Squared Errors = " + WSSSE)
	}
}