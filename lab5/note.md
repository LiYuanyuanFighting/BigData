1.  for (ProductWritable p : values) {
        		// user.addScore(p);
    	    sum += p.getScore();
    		size++;
    		newProducts.add(new ProductWritable(p));// should add new ProductWritable, otw always be replaced
    	}
2.   avg=totRatings/(double)numRatings; // should add (double) or (float)   


    float is represented in 32 bits, with 1 sign bit, 8 bits of exponent, and 23 bits of the significand (or what follows from a scientific-notation number: 2.33728*1012; 33728 is the significand).

    double is represented in 64 bits, with 1 sign bit, 11 bits of exponent, and 52 bits of significand.
