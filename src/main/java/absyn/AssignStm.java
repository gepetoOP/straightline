package absyn;

import io.vavr.collection.Tree;

import java.util.Map;

public class AssignStm extends Stm {

   public final String id;
   public final Exp exp;

   public AssignStm(String id, Exp exp) {
      this.id = id;
      this.exp = exp;
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("AssignStm", Tree.of(id), exp.toTree());
   }

   @Override
   public int maxargs() {
      return exp.maxargs();
   }

   @Override
   public void interp(Map<String, Double> mem) {
      mem.put(id, exp.eval(mem));
   }
}
