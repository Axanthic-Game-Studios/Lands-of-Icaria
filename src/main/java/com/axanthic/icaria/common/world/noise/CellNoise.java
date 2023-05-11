/*
 * Copyright (C) 2003, 2004 Jason Bevins (original libnoise code)
 * Copyright � 2010 Thomas J. Hodge (java port of libnoise)
 *
 * This file was part of libnoiseforjava.
 *
 * libnoiseforjava is a Java port of the C++ library libnoise, which may be found at
 * http://libnoise.sourceforge.net/.  libnoise was developed by Jason Bevins, who may be
 * contacted at jlbezigvins@gmzigail.com (for great email, take off every 'zig').
 * Porting to Java was done by Thomas Hodge, who may be contacted at
 * libnoisezagforjava@gzagmail.com (remove every 'zag').
 *
 * libnoiseforjava is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * libnoiseforjava is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * libnoiseforjava.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.axanthic.icaria.common.world.noise;

import java.util.Random;

/**
 * This is a Voronoi noise generator, originally from
 * https://github.com/TJHJava/libnoiseforjava It was modified to work in a
 * similar way to the bukkit noise generators, and to support octaves and 2d
 * noise,
 *
 * by mncat77 and jtjj222. <----------
 */
public class CellNoise {
	private static final double SQRT_2 = 1.4142135623730950488;
	private static final double SQRT_3 = 1.7320508075688772935;

	private boolean useDistance = false;

	private long seed;
	private short distanceMethod;

	public CellNoise(final long seed, final short distanceMethod) {
		this.seed = seed;
		this.distanceMethod = distanceMethod;
	}

	private double distance(final double xDist, final double zDist) {
		return Math.sqrt(xDist * xDist + zDist * zDist);
	}

	private double getDistance2D(final double xDist, final double zDist) {
		switch (this.distanceMethod) {
		case 0:
			return Math.sqrt(xDist * xDist + zDist * zDist) / CellNoise.SQRT_2;
		case 1:
			return xDist + zDist;
		default:
			return Double.NaN;
		}
	}

	private double getDistance(final double xDist, final double yDist, final double zDist) {
		switch (this.distanceMethod) {
		case 0:
			return Math.sqrt(xDist * xDist + yDist * yDist + zDist * zDist) / CellNoise.SQRT_3; // Approximation (for
																								// speed) of elucidean
																								// (regular) distance
		case 1:
			return xDist + yDist + zDist;
		default:
			return Double.NaN;
		}
	}

	public boolean isUseDistance() {
		return this.useDistance;
	}

	public void setUseDistance(final boolean useDistance) {
		this.useDistance = useDistance;
	}

	public short getDistanceMethod() {
		return this.distanceMethod;
	}

	public long getSeed() {
		return this.seed;
	}

	public void setDistanceMethod(final short distanceMethod) {
		this.distanceMethod = distanceMethod;
	}

	public void setSeed(final long seed) {
		this.seed = seed;
	}

	public float noise(double x, double z, final double frequency) {
		x *= frequency;
		z *= frequency;

		final int xInt = x > .0 ? (int) x : (int) x - 1;
		final int zInt = z > .0 ? (int) z : (int) z - 1;

		double minDist = 32000000.0;

		double xCandidate = 0;
		double zCandidate = 0;

		for (int zCur = zInt - 2; zCur <= zInt + 2; zCur++) {
			for (int xCur = xInt - 2; xCur <= xInt + 2; xCur++) {

				final double xPos = xCur + CellNoise.valueNoise2D(xCur, zCur, this.seed);
				final double zPos = zCur + CellNoise.valueNoise2D(xCur, zCur, new Random(this.seed).nextLong());
				final double xDist = xPos - x;
				final double zDist = zPos - z;
				final double dist = xDist * xDist + zDist * zDist;

				if (dist < minDist) {
					minDist = dist;
					xCandidate = xPos;
					zCandidate = zPos;
				}
			}
		}

		if (this.useDistance) {
			final double xDist = xCandidate - x;
			final double zDist = zCandidate - z;
			return (float) this.getDistance2D(xDist, zDist);
		}
		return (float) CellNoise.valueNoise2D((int) Math.floor(xCandidate), (int) Math.floor(zCandidate), this.seed);
	}

	public float border2(double x, double z, final double width, final float depth) {
		x *= 1D;
		z *= 1D;

		final int xInt = x > .0 ? (int) x : (int) x - 1;
		final int zInt = z > .0 ? (int) z : (int) z - 1;

		double dCandidate = 32000000.0;
		double xCandidate = 0;
		double zCandidate = 0;

		double dNeighbour = 32000000.0;
		double xNeighbour = 0;
		double zNeighbour = 0;

		double xPos, zPos, xDist, zDist, dist;
		for (int zCur = zInt - 2; zCur <= zInt + 2; zCur++) {
			for (int xCur = xInt - 2; xCur <= xInt + 2; xCur++) {
				xPos = xCur + CellNoise.valueNoise2D(xCur, zCur, this.seed);
				zPos = zCur + CellNoise.valueNoise2D(xCur, zCur, new Random(this.seed).nextLong());
				xDist = xPos - x;
				zDist = zPos - z;
				dist = this.distance(xPos - x, zPos - z);

				if (dist < dCandidate) {
					dNeighbour = dCandidate;
					xNeighbour = xCandidate;
					zNeighbour = zCandidate;

					dCandidate = dist;
					xCandidate = xPos;
					zCandidate = zPos;
				} else if (dist > dCandidate && dist < dNeighbour) {
					dNeighbour = dist;
					xNeighbour = xPos;
					zNeighbour = zPos;
				}
			}
		}

		final double diff = this.distance(xCandidate - xNeighbour, zCandidate - zNeighbour);
		final double total = (dCandidate + dNeighbour) / diff;

		dCandidate = dCandidate / total;
		dNeighbour = dNeighbour / total;

		final double c = diff / 2D - dCandidate;
		if (c < width) {
			return ((float) (c / width) - 1f) * depth;
		}
		return 0f;
	}

	public float border(double x, double z, final double width, final float depth) {
		x *= 1D;
		z *= 1D;

		final int xInt = x > .0 ? (int) x : (int) x - 1;
		final int zInt = z > .0 ? (int) z : (int) z - 1;

		double dCandidate = 32000000.0;
		final double xCandidate = 0;
		final double zCandidate = 0;

		double dNeighbour = 32000000.0;
		final double xNeighbour = 0;
		final double zNeighbour = 0;

		for (int zCur = zInt - 2; zCur <= zInt + 2; zCur++) {
			for (int xCur = xInt - 2; xCur <= xInt + 2; xCur++) {

				final double xPos = xCur + CellNoise.valueNoise2D(xCur, zCur, this.seed);
				final double zPos = zCur + CellNoise.valueNoise2D(xCur, zCur, new Random(this.seed).nextLong());
				final double xDist = xPos - x;
				final double zDist = zPos - z;
				// double dist = xDist * xDist + zDist * zDist;
				final double dist = this.getDistance2D(xPos - x, zPos - z);

				if (dist < dCandidate) {
					dNeighbour = dCandidate;
					dCandidate = dist;

					/*
					 * dNeighbour = dCandidate; xNeighbour = xCandidate; zNeighbour = zCandidate;
					 * dCandidate = dist; xCandidate = xPos; zCandidate = zPos;
					 */
				} else if (dist < dNeighbour) {
					dNeighbour = dist;
				}
			}
		}

		// double c = getDistance2D(xNeighbour - x, zNeighbour - z) -
		// getDistance2D(xCandidate - x, zCandidate - z);
		final double c = dNeighbour - dCandidate;
		if (c < width) {
			return ((float) (c / width) - 1f) * depth;
		}
		return 0f;
	}

	public double noise(double x, double y, double z, final double frequency) {
		// Inside each unit cube, there is a seed point at a random position. Go
		// through each of the nearby cubes until we find a cube with a seed point
		// that is closest to the specified position.
		x *= frequency;
		y *= frequency;
		z *= frequency;

		final int xInt = x > .0 ? (int) x : (int) x - 1;
		final int yInt = y > .0 ? (int) y : (int) y - 1;
		final int zInt = z > .0 ? (int) z : (int) z - 1;

		double minDist = 32000000.0;

		double xCandidate = 0;
		double yCandidate = 0;
		double zCandidate = 0;

		final Random rand = new Random(this.seed);

		for (int zCur = zInt - 2; zCur <= zInt + 2; zCur++) {
			for (int yCur = yInt - 2; yCur <= yInt + 2; yCur++) {
				for (int xCur = xInt - 2; xCur <= xInt + 2; xCur++) {
					// Calculate the position and distance to the seed point inside of
					// this unit cube.

					final double xPos = xCur + CellNoise.valueNoise3D(xCur, yCur, zCur, this.seed);
					final double yPos = yCur + CellNoise.valueNoise3D(xCur, yCur, zCur, rand.nextLong());
					final double zPos = zCur + CellNoise.valueNoise3D(xCur, yCur, zCur, rand.nextLong());
					final double xDist = xPos - x;
					final double yDist = yPos - y;
					final double zDist = zPos - z;
					final double dist = xDist * xDist + yDist * yDist + zDist * zDist;

					if (dist < minDist) {
						// This seed point is closer to any others found so far, so record
						// this seed point.
						minDist = dist;
						xCandidate = xPos;
						yCandidate = yPos;
						zCandidate = zPos;
					}
				}
			}
		}

		if (this.useDistance) {
			final double xDist = xCandidate - x;
			final double yDist = yCandidate - y;
			final double zDist = zCandidate - z;

			return this.getDistance(xDist, yDist, zDist);
		}
		return CellNoise.valueNoise3D((int) Math.floor(xCandidate), (int) Math.floor(yCandidate),
				(int) Math.floor(zCandidate), this.seed);

	}

	/**
	 * To avoid having to store the feature points, we use a hash function of the
	 * coordinates and the seed instead. Those big scary numbers are arbitrary
	 * primes.
	 */
	public static double valueNoise2D(final int x, final int z, final long seed) {
		long n = 1619 * x + 6971 * z + 1013 * seed & 0x7fffffff;
		n = n >> 13 ^ n;
		return 1.0 - (n * (n * n * 60493 + 19990303) + 1376312589 & 0x7fffffff) / 1073741824.0;
	}

	public static double valueNoise3D(final int x, final int y, final int z, final long seed) {
		long n = 1619 * x + 31337 * y + 6971 * z + 1013 * seed & 0x7fffffff;
		n = n >> 13 ^ n;
		return 1.0 - (n * (n * n * 60493 + 19990303) + 1376312589 & 0x7fffffff) / 1073741824.0;
	}
}