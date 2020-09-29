public class VectorCalculator extends AbstractCalculator {

    public VectorCalculator(){
        super((x,y)->{
            Number solution = new Number();
            solution.setA(x.getA()+y.getA());
            solution.setB(x.getB()+y.getB());
            return solution;
        },(x, y) -> {
            Number solution = new Number();
            solution.setA(x.getA()-y.getA());
            solution.setB(x.getB()-y.getB());
            return solution;
        },(x, y) -> {
            Number solution = new Number();
            solution.setA(x.getA()*y.getB()-y.getA()*x.getB());
            return solution;
        },(x, y) -> {
            Number solution = new Number();
            solution.setA(x.getA()*y.getA()+x.getB()*y.getB());
            return solution;
        });
    }

    @Override
    public Number add(Number a, Number b) {
        return add.calc(a,b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return subtract.calc(a,b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return multiply.calc(a,b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return divide.calc(a,b);
    }
}
