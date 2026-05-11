package gestionComodines;

	public class GestionComodines {

	    // 1. 50:50 
		/**
		 * COMODÍN 50:50 (Versión Final)
		 * Elige 2 botones incorrectos al azar para ocultar.
		 */
		public int[] usar50porCientoFinal(int respuestaCorrecta) {
		    int[] incorrectas = new int[3];
		    int contador = 0;

		    // Guardamos los índices de los 3 botones que están mal
		    for (int i = 0; i < 4; i++) {
		        if (i != respuestaCorrecta) {
		            incorrectas[contador] = i;
		            contador++;
		        }
		    }

		    // Mezclamos las 3 opciones incorrectas
		    for (int i = 0; i < incorrectas.length; i++) {
		        int azar = (int) (Math.random() * incorrectas.length);
		        int temp = incorrectas[azar];
		        incorrectas[azar] = incorrectas[i];
		        incorrectas[i] = temp;
		    }

		    // Devolvemos las dos primeras de la mezcla
		    return new int[]{incorrectas[0], incorrectas[1]};
		}

	    // 2. LA RULETA 
	    /**
	     * COMODÍN DE LA RULETA (Versión Avanzada)
	     * Quita aleatoriamente 1, 2 o 3 respuestas incorrectas.
	     * @param respuestaCorrecta El índice de la opción que NO debe borrarse (0-3).
	     * @return Un array con los índices de las respuestas que la interfaz debe ocultar.
	     */
	    public int[] usarRuletaAleatoria(int respuestaCorrecta) {
	        // 1. La ruleta decide cuántas quitar: un número aleatorio entre 1 y 3
	        int cuantasQuitar = (int) (Math.random() * 3) + 1;
	        
	        int[] eliminar = new int[cuantasQuitar];
	        int cont = 0;
	        
	        // 2. Llenamos el array con las respuestas que NO son la correcta
	        // Recorremos las opciones (A=0, B=1, C=2, D=3)
	        for (int i = 0; i < 4; i++) {
	            // Si no es la correcta y aún no hemos llegado al límite que dijo la ruleta...
	            if (i != respuestaCorrecta && cont < cuantasQuitar) {
	                eliminar[cont] = i;
	                cont++;
	            }
	        }
	        
	        // Si la ruleta decidió quitar menos de las disponibles, 
	        // el array será más pequeño, lo cual es perfecto.
	        return eliminar;
	    }

	    // 3. LA LLAMADA 
	    public int[] usarLlamada(int respuestaCorrecta) {
	        int[] porcentajes = new int[4];

	        porcentajes[respuestaCorrecta] = (int) (Math.random() * 31) + 50;

	        int restante = 100 - porcentajes[respuestaCorrecta];


	        for (int i = 0; i < 4; i++) {
	            if (i != respuestaCorrecta) {
	                porcentajes[i] = restante / 3; 
	            }
	        }
	        return porcentajes;
	    }

	    // 4. EL MAGO 
	    public boolean puedeUsarMago(int nivelActual) {
	        return nivelActual >= 10;

	    }

	}