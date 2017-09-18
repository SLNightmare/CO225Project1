import java.math.*;

class Complex{
	
	private double a,b;

	public Complex(double x, double y){
            this.a = x;
            this.b = y;
	}

	public Complex getsquare(){
            return new Complex(Math.pow(this.a,2)-Math.pow(this.b,2),2*(this.a)*(this.b));
	}

	public Complex addComplex(Complex d){
            return new Complex(d.getReal()+this.getReal(),d.getImg()+this.getImg());
	}

	public double absolute(){
            return (Math.pow(this.a,2)+Math.pow(this.b,2));
	}

	public double getReal(){
            return this.a;
	}

	public double getImg(){
            return this.b;
	}

	public Complex calPosition(Point p){
            double real = p.getX()*(Fractal.xRight - Fractal.xLeft)/800;
            double img = p.getY()*(Fractal.yUp - Fractal.yDown)/800;
            return new Complex(real + Fractal.xLeft, Fractal.yUp - img);
	}
        
        public int checkMandelbrot(){
            Complex C = new Complex(0,0);
            int i;
            for(i=1;i<Fractal.maxIterations && C.absolute()<4;++i){
                C = C.getsquare().addComplex(this);
            }
            return i;
        }
        
        public int checkJulia(Complex d){
            Complex C = this;
            int i;
            for(i=1;i<Fractal.maxIterations && C.absolute()<4;++i){
                C = C.getsquare().addComplex(d);
            }
            return i;
        }

}