

	public class GestionComodines {

	    // 1. 50:50 
		public int[] usar50porCientoFinal(int respuestaCorrecta) {
		    int[] incorrectas = new int[3];
		    int contador = 0;

		 
		    for (int i = 0; i < 4; i++) {
		        if (i != respuestaCorrecta) {
		            incorrectas[contador] = i;
		            contador++;
		        }
		    }

		
		    for (int i = 0; i < incorrectas.length; i++) {
		        int azar = (int) (Math.random() * incorrectas.length);
		        int temp = incorrectas[azar];
		        incorrectas[azar] = incorrectas[i];
		        incorrectas[i] = temp;
		    }

		  
		    return new int[]{incorrectas[0], incorrectas[1]};
		}

	    // 2. LA RULETA 
	    
	    public int[] usarRuletaAleatoria(int respuestaCorrecta) {
	       
	        int cuantasQuitar = (int) (Math.random() * 3) + 1;
	        
	        int[] eliminar = new int[cuantasQuitar];
	        int cont = 0;
	        
	    
	        for (int i = 0; i < 4; i++) {
	          
	            if (i != respuestaCorrecta && cont < cuantasQuitar) {
	                eliminar[cont] = i;
	                cont++;
	            }
	        }
	        
	        
	        return eliminar;
	    }

	 // 3. LA LLAMADA
	    public String usarLlamada(int respuestaCorrecta) {
	        String[] opciones = {"A", "B", "C", "D"};
	        int probabilidadAcierto = (int) (Math.random() * 100);
	        int respuestaSugerida;

	       
	        if (probabilidadAcierto > 20) {
	            respuestaSugerida = respuestaCorrecta;
	            return "Hola! Pues estoy casi seguro de que la respuesta correcta es la " + opciones[respuestaSugerida] + ".";
	        } else {
	          
	            do {
	                respuestaSugerida = (int) (Math.random() * 4);
	            } while (respuestaSugerida == respuestaCorrecta);
	            
	            return "Uff, qué difícil... no lo sé seguro, pero yo diría que es la " + opciones[respuestaSugerida] + ".";
	        }
	    }

	    // 4. USAR CHAT
	    public int[] usarChat(int respuestaCorrecta) {
	        int[] porcentajes = new int[4];
	        int restante = 100;

	      
	        porcentajes[respuestaCorrecta] = (int) (Math.random() * 51) + 40;
	        restante -= porcentajes[respuestaCorrecta];

	       
	        for (int i = 0; i < 4; i++) {
	            if (i != respuestaCorrecta) {
	                int azar = (int) (Math.random() * (restante + 1));
	               
	                if (i == 3 || (i == 2 && respuestaCorrecta == 3) || (i == 1 && respuestaCorrecta >= 2)) {
	                    porcentajes[i] = restante;
	                    restante = 0;
	                } else {
	                    porcentajes[i] = azar;
	                    restante -= azar;
	                }
	            }
	        }
	        return porcentajes;
	    }

	    }

	