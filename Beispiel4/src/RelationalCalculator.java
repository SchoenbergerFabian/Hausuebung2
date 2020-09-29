public class RelationalCalculator extends AbstractCalculator {

    public RelationalCalculator(){
        super((x,y)->{
            Number solution = new Number();
            double a;
            double b;
            if(x.getB()!=y.getB()){
                a = x.getA()*y.getB()+y.getA()*x.getB();
                b = x.getB()*y.getB();
            }else{
                a = x.getA() + y.getA();
                b = x.getB();
            }
            solution.setA(a);
            solution.setB(b);
            return solution;
        },(x, y) -> {
            Number solution = new Number();
            double a;
            double b;
            if(x.getB()!=y.getB()){
                a = x.getA()*y.getB()-y.getA()*x.getB();
                b = x.getB()*y.getB();
            }else{
                a = x.getA() - y.getA();
                b = x.getB();
            }
            solution.setA(a);
            solution.setB(b);
            return solution;
        },(x, y) -> {
            Number solution = new Number();
            solution.setA(x.getA()*y.getA());
            solution.setB(x.getB()*y.getB());
            return solution;
        },(x, y) -> {
            Number solution = new Number();
            solution.setA(x.getA()*y.getB());
            solution.setB(x.getB()*y.getA());
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
