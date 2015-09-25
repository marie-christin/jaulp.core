/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.file.csv;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.alpharogroup.file.FileUtils;
import de.alpharogroup.file.search.FileSearchUtils;
import de.alpharogroup.file.search.PathFinder;
import de.alpharogroup.file.write.WriteFileUtils;

/**
 * The Class CsvToSqlUtilsTest.
 */
public class CsvToSqlUtilsTest
{

	/**
	 * Gets the all files from provinces code left.
	 *
	 * @return the all files from provinces code left
	 */
	public static List<File> getAllFilesFromProvincesCodeLeft()
	{
		final File currentDir = new File(".");
		final File projectDirectory = PathFinder.getProjectDirectory(currentDir);

		final String pathToFile = "/iso3611/provinces/codeLeft";

		final File srcTestResourcesDir = PathFinder.getSrcTestResourcesDir(projectDirectory);

		final File filePathToFile = new File(srcTestResourcesDir, pathToFile);

		return FileSearchUtils.getAllFilesFromDir(filePathToFile);
	}

	/**
	 * Gets the all files from provinces code left with subdivision.
	 *
	 * @return the all files from provinces code left with subdivision
	 */
	public static List<File> getAllFilesFromProvincesCodeLeftWithSubdivision()
	{
		final File currentDir = new File(".");
		final File projectDirectory = PathFinder.getProjectDirectory(currentDir);

		final String pathToFile = "/iso3611/provinces/codeLeftWithSubdivision";

		final File srcTestResourcesDir = PathFinder.getSrcTestResourcesDir(projectDirectory);

		final File filePathToFile = new File(srcTestResourcesDir, pathToFile);

		return FileSearchUtils.getAllFilesFromDir(filePathToFile);
	}

	// @Test
	// public void testExtractGreatBritainProvinces() throws IOException {
	// File currentDir = new File( "." );
	// final File projectDirectory = PathFinder
	// .getProjectDirectory( currentDir );
	//
	// final String pathToFile = "/iso3611/countries/";
	// final String filename = "englishProvinces.csv";
	// final File srcMainResourcesDir = PathFinder
	// .getSrcTestResourcesDir( projectDirectory );
	// final File filePathToFile = new File( srcMainResourcesDir, pathToFile );
	//
	// final File file = new File( filePathToFile, filename );
	// final List< String [] > lines = CsvFileUtils.readFileToList( file, ";",
	// "UTF-8" );
	// String [] header = { "Code", "Subdivision name",
	// "Subdivision category", "In country/province/principality" };
	// String [] columnTypes = { "text", "text", "text", "text" };
	// String [] columnTypesEdit = { "edit,-,.,true", null, null, null };
	// CsvBean csvBean = new CsvBean( header, columnTypes, columnTypesEdit,
	// lines );
	// String sqlScript = CsvToSqlUtils.getCsvFileAsSqlInsertScript(
	// "federalstates", csvBean );
	// System.out.println( sqlScript );
	// }

	// @Test
	// public void testExtractGreatBritainProvincesAndChangeOrder() throws IOException {
	// File currentDir = new File( "." );
	// final File projectDirectory = PathFinder
	// .getProjectDirectory( currentDir );
	//
	// final String pathToFile = "/iso3611/countries/";
	// final String filename = "englishProvinces.csv";
	// final File srcTestResourcesDir = PathFinder
	// .getSrcTestResourcesDir( projectDirectory );
	// final File filePathToFile = new File( srcTestResourcesDir, pathToFile );
	// final File file = new File( filePathToFile, filename );
	//
	// String [] header = { "id", "country_id", "name", "iso3166_a2code",
	// "subdivision_name", "subdivision_category" };
	// String [] columnTypes = { "int", "int", "text", "text", "text",
	// "text" };
	//
	// String startIndex = "1";
	// String column_00 = "autoincrement,"+ startIndex; // The id to autoincrement
	// String foreignKey = "232";
	// String column_01 = "constant,int," + foreignKey; // This is a foreign key
	// // Edit the column and replace '-' with '.' if true suround value with qoutes
	// String column_03 = "edit,-,.,true";
	// String [] columnTypesEdit = { column_00, column_01,
	// null, column_03, null, null };
	//
	//
	// Map< Integer, Integer > lineOrder = new HashMap< Integer, Integer >();
	// lineOrder.put( 0, 3 );
	// lineOrder.put( 1, 2 );
	// lineOrder.put( 2, 5 );
	// lineOrder.put( 3, 4 );
	//
	// String sqlScript = getSqlScriptFromCsvFile(file, header, columnTypes,
	// columnTypesEdit, lineOrder);
	//
	// System.out.println( sqlScript );
	//
	// }

	// @Test
	// public void testExtractProvincesFileList() throws IOException {
	//
	// Map<String, String> iso3166A2nameToId = getIso3166A2nameToIdMap();
	// for (Iterator<String> iterator = iso3166A2nameToId.keySet().iterator(); iterator.hasNext();)
	// {
	// String key = iterator.next();
	// String value = iso3166A2nameToId.get(key);
	// System.out.println(key + ":" + value);
	// }
	// }

	/**
	 * Gets the all files from provinces code right.
	 *
	 * @return the all files from provinces code right
	 */
	public static List<File> getAllFilesFromProvincesCodeRight()
	{
		final File currentDir = new File(".");
		final File projectDirectory = PathFinder.getProjectDirectory(currentDir);

		final String pathToFile = "/iso3611/provinces/codeRight";

		final File srcTestResourcesDir = PathFinder.getSrcTestResourcesDir(projectDirectory);

		final File filePathToFile = new File(srcTestResourcesDir, pathToFile);

		return FileSearchUtils.getAllFilesFromDir(filePathToFile);
	}

	/**
	 * Gets the iso3166 a2name to id map.
	 *
	 * @return the iso3166 a2name to id map
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Map<String, String> getIso3166A2nameToIdMap() throws IOException
	{
		final File currentDir = new File(".");
		final File projectDirectory = PathFinder.getProjectDirectory(currentDir);

		final String pathToFile = "/iso3611/provinces/";
		final String filename = "iso3166_a2nameToId.csv";

		final File srcTestResourcesDir = PathFinder.getSrcTestResourcesDir(projectDirectory);
		final File filePathToFile = new File(srcTestResourcesDir, pathToFile);

		final File file = new File(filePathToFile, filename);
		final List<String[]> lines = CsvFileUtils.readFileToList(file, ";", "UTF-8");
		final Map<String, String> iso3166A2nameToId = new HashMap<>(lines.size());
		for (final String[] strings : lines)
		{
			iso3166A2nameToId.put(strings[0], strings[1]);
		}
		return iso3166A2nameToId;
	}

	/**
	 * Gets the sql script from csv file.
	 *
	 * @param file
	 *            the file
	 * @param header
	 *            the header
	 * @param columnTypes
	 *            the column types
	 * @param columnTypesEdit
	 *            the column types edit
	 * @param lineOrder
	 *            the line order
	 * @return the sql script from csv file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private String getSqlScriptFromCsvFile(final File file, final String[] header,
		final String[] columnTypes, final String[] columnTypesEdit,
		final Map<Integer, Integer> lineOrder) throws IOException
	{
		final List<String[]> lines = CsvFileUtils.readFileToList(file, ";", "UTF-8");
		final CsvBean newCsvBean = new CsvBean(header, columnTypes, columnTypesEdit, lines);
		newCsvBean.setLineOrder(lineOrder);
		final String sqlScript = CsvToSqlUtils.getCsvFileAsSqlInsertScript("federalstates",
			newCsvBean, false, false);
		return sqlScript;
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeMethod
	public void setUp() throws Exception
	{
	}


	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@AfterMethod
	public void tearDown() throws Exception
	{
	}


	/**
	 * Test extract only code left csv files.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testExtractOnlyCodeLeftCsvFiles() throws IOException
	{
		final List<File> codeLeftFileList = getAllFilesFromProvincesCodeLeft();
		final StringBuffer sb = new StringBuffer();
		final Map<String, String> iso3166A2nameToIdMap = getIso3166A2nameToIdMap();
		final String[] header = { "id", "country_id", "name", "iso3166_a2code", "subdivision_name",
				"subdivision_category" };
		final String[] columnTypes = { "int", "int", "text", "text", "text", "text" };
		final Map<Integer, Integer> lineOrder = new HashMap<>();
		lineOrder.put(0, 3); // Set index 0 from csv to index 3 from the table...
		lineOrder.put(1, 2); // Set index 1 from csv to index 2 from the table...

		int continueIndex = 231;
		for (final File file : codeLeftFileList)
		{
			final int count = CsvFileUtils.getLineCountFromCsvFile(file);
			final String filenamePrefix = FileUtils.getFilenameWithoutExtension(file);
			final String foreignKey = iso3166A2nameToIdMap.get(filenamePrefix);

			final int startIndex = continueIndex;
			final String column_00 = "autoincrement," + startIndex; // The id to autoincrement
			final String column_01 = "constant,int," + foreignKey; // This is a foreign key
			// Edit the column and replace '-' with '.' if true suround value with qoutes
			final String column_03 = "edit,-,.,true";
			final String[] columnTypesEdit = { column_00, column_01, null, column_03, null, null };

			final String result = getSqlScriptFromCsvFile(file, header, columnTypes,
				columnTypesEdit, lineOrder);
			sb.append(result);
			continueIndex = continueIndex + count;
		}
		final String res = sb.toString();
		final File srcTestResourcesDir = PathFinder.getSrcTestResourcesDir();
		final File f = new File(srcTestResourcesDir, "resultCodeLeft.txt");
		WriteFileUtils.writeStringToFile(f, res, "UTF-8");
		System.out.println(res);
	}

	/**
	 * Test extract only code left with subdivision csv files.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testExtractOnlyCodeLeftWithSubdivisionCsvFiles() throws IOException
	{
		final List<File> codeRightFileList = getAllFilesFromProvincesCodeLeftWithSubdivision();
		final StringBuffer sb = new StringBuffer();
		final Map<String, String> iso3166A2nameToIdMap = getIso3166A2nameToIdMap();
		final String[] header = { "id", "country_id", "name", "iso3166_a2code", "subdivision_name",
				"subdivision_category" };
		final String[] columnTypes = { "int", "int", "text", "text", "text", "text" };
		final Map<Integer, Integer> lineOrder = new HashMap<>();
		lineOrder.put(0, 3); // Set index 0 from csv to index 2 from the table...
		lineOrder.put(1, 2); // Set index 1 from csv to index 3 from the table...
		lineOrder.put(2, 5); // Set index 2 from csv to index 5 from the table...

		int continueIndex = 2647;
		for (final File file : codeRightFileList)
		{
			final int count = CsvFileUtils.getLineCountFromCsvFile(file);
			final String filenamePrefix = FileUtils.getFilenameWithoutExtension(file);
			final String foreignKey = iso3166A2nameToIdMap.get(filenamePrefix);

			final int startIndex = continueIndex;
			final String column_00 = "autoincrement," + startIndex; // The id to autoincrement
			final String column_01 = "constant,int," + foreignKey; // This is a foreign key
			// Edit the column and replace '-' with '.' if true suround value with qoutes
			final String column_03 = "edit,-,.,true";
			final String[] columnTypesEdit = { column_00, column_01, null, column_03, null, null };

			final String result = getSqlScriptFromCsvFile(file, header, columnTypes,
				columnTypesEdit, lineOrder);
			sb.append(result);
			continueIndex = continueIndex + count;
		}
		final String res = sb.toString();
		final File currentDir = new File(".");
		final File projectDirectory = PathFinder.getProjectDirectory(currentDir);

		final File srcTestResourcesDir = PathFinder.getSrcTestResourcesDir(projectDirectory);
		final File f = new File(srcTestResourcesDir, "resultCodeLeftWithSubdivision.txt");
		WriteFileUtils.writeStringToFile(f, res, "UTF-8");
		System.out.println(res);
	}

	/**
	 * Test extract only code right csv files.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testExtractOnlyCodeRightCsvFiles() throws IOException
	{
		final List<File> codeRightFileList = getAllFilesFromProvincesCodeRight();
		final StringBuffer sb = new StringBuffer();
		final Map<String, String> iso3166A2nameToIdMap = getIso3166A2nameToIdMap();
		final String[] header = { "id", "country_id", "name", "iso3166_a2code", "subdivision_name",
				"subdivision_category" };
		final String[] columnTypes = { "int", "int", "text", "text", "text", "text" };
		final Map<Integer, Integer> lineOrder = new HashMap<>();
		lineOrder.put(0, 2); // Set index 0 from csv to index 2 from the table...
		lineOrder.put(1, 3); // Set index 1 from csv to index 3 from the table...

		int continueIndex = 2167;
		for (final File file : codeRightFileList)
		{
			final int count = CsvFileUtils.getLineCountFromCsvFile(file);
			final String filenamePrefix = FileUtils.getFilenameWithoutExtension(file);
			final String foreignKey = iso3166A2nameToIdMap.get(filenamePrefix);

			final int startIndex = continueIndex;
			final String column_00 = "autoincrement," + startIndex; // The id to autoincrement
			final String column_01 = "constant,int," + foreignKey; // This is a foreign key
			// Edit the column and replace '-' with '.' if true suround value with qoutes
			final String column_03 = "edit,-,.,true";
			final String[] columnTypesEdit = { column_00, column_01, null, column_03, null, null };

			final String result = getSqlScriptFromCsvFile(file, header, columnTypes,
				columnTypesEdit, lineOrder);
			sb.append(result);
			continueIndex = continueIndex + count;
		}
		final String res = sb.toString();
		final File currentDir = new File(".");
		final File projectDirectory = PathFinder.getProjectDirectory(currentDir);

		final File srcTestResourcesDir = PathFinder.getSrcTestResourcesDir(projectDirectory);
		final File f = new File(srcTestResourcesDir, "resultCodeRight.txt");
		WriteFileUtils.writeStringToFile(f, res, "UTF-8");
		System.out.println(res);
	}

}
