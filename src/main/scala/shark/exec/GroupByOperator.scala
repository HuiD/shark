package shark.exec

import org.apache.hadoop.hive.ql.exec.{GroupByOperator => HiveGroupByOperator}
import org.apache.hadoop.hive.ql.exec.{ReduceSinkOperator => HiveReduceSinkOperator}
import org.apache.hadoop.hive.ql.plan.GroupByDesc


/**
 * Unlike Hive, group by in Shark is split into two different operators:
 * GroupByPostShuffleOperator and GroupByPreShuffleOperator. The pre-shuffle one
 * serves as a combiner on each map partition.
 */
object GroupByOperator {
  
  def isPostShuffle(op: HiveGroupByOperator): Boolean = {
    op.getParentOperators().get(0).isInstanceOf[HiveReduceSinkOperator]
  }
  
}

