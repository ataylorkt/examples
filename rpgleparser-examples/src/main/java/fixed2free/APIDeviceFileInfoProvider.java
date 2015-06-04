package fixed2free;

import com.ibm.as400.access.AS400Bin2;
import com.ibm.as400.access.AS400Bin4;
import com.ibm.as400.access.AS400DataType;
import com.ibm.as400.access.AS400PackedDecimal;
import com.ibm.as400.access.AS400Structure;
import com.ibm.as400.access.AS400Text;

import fixed2free.integration.DeviceFileInfoProvider;

public class APIDeviceFileInfoProvider implements DeviceFileInfoProvider {

	// FLDL0100 List Data Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 CHAR(10) Field name
	AS400Text fieldName = new AS400Text(10);
	// 10 A CHAR(1) Data type
	AS400Text dataType = new AS400Text(1);
	// 11 B CHAR(1) Use
	AS400Text use = new AS400Text(1);
	// 12 C BINARY(4) Output buffer position
	AS400Bin4 outputBufferPosition = new AS400Bin4();
	// 16 10 BINARY(4) Input buffer position
	AS400Bin4 inputBufferPosition = new AS400Bin4();
	// 20 14 BINARY(4) Field length in bytes
	AS400Bin4 fieldLengthInBytes = new AS400Bin4();
	// 24 18 BINARY(4) Digits
	AS400Bin4 digits = new AS400Bin4();
	// 28 1C BINARY(4) Decimal position
	AS400Bin4 decimalPositions = new AS400Bin4();
	// 32 20 CHAR(50) Field text description
	AS400Text fieldTextDescription = new AS400Text(50);
	// 82 52 CHAR(2) Edit code
	AS400Text editCode = new AS400Text(2);
	// 84 54 BINARY(4) Edit word length
	AS400Bin4 editWordLength = new AS400Bin4();
	// 88 58 CHAR(64) Edit word
	AS400Text editWord = new AS400Text(64);
	// 152 98 CHAR(20) Column heading 1
	AS400Text columnHeading1 = new AS400Text(20);
	// 172 AC CHAR(20) Column heading 2
	AS400Text columnHeading2 = new AS400Text(20);
	// 192 C0 CHAR(20) Column heading 3
	AS400Text columnHeading3 = new AS400Text(20);
	// 212 D4 CHAR(10) Internal field name
	AS400Text internalFieldName = new AS400Text(10);
	// 222 DE CHAR(30) Alternative field name
	AS400Text alternativeFieldName = new AS400Text(30);
	// 252 FC BINARY(4) Length of alternative field name
	AS400Bin4 alternativeFieldNameLength = new AS400Bin4();
	// 256 100 BINARY(4) Number of DBCS characters
	AS400Bin4 numberOfDBCSCharacters = new AS400Bin4();
	// 260 104 CHAR(1) Null values allowed
	AS400Text nullValuesAllowed = new AS400Text(1);
	// 261 105 CHAR(1) Host variable indicator
	AS400Text hostVariableIndicator = new AS400Text(1);
	// 262 106 CHAR(4) Date and time format
	AS400Text dateAndTimeFormat = new AS400Text(4);
	// 266 10A CHAR(1) Date and time separator
	AS400Text dateAndTimeSeparator = new AS400Text(1);
	// 267 10B CHAR(1) Variable length field indicator (overlay for MI mapping)
	AS400Text variableLengthFieldIndicator = new AS400Text(1);
	// 268 10C BINARY(4) Field text description CCSID
	AS400Bin4 fieldTextDescriptionCCSID = new AS400Bin4();
	// 272 110 BINARY(4) Field data CCSID
	AS400Bin4 fieldDataCCSID = new AS400Bin4();
	// 276 114 BINARY(4) Field column headings CCSID
	AS400Bin4 fieldColumnHeadingsCCSID = new AS400Bin4();
	// 280 118 BINARY(4) Field edit words CCSID
	AS400Bin4 fieldEditWordsCCSID = new AS400Bin4();
	// 284 11C BINARY(4) UCS-2 displayed field length
	AS400Bin4 ucs2DisplayedFieldLength = new AS400Bin4();
	// 288 120 BINARY(4) Field data encoding scheme
	AS400Bin4 fieldDataEncodingScheme = new AS400Bin4();
	// 292 124 BINARY(4) Maximum large object field length
	AS400Bin4 maximumLargeObjectFieldLength = new AS400Bin4();
	// 296 128 BINARY(4) Pad length for large object
	AS400Bin4 padLengthForLargeObject = new AS400Bin4();
	// 300 12C BINARY(4) Length of user-defined type name
	AS400Bin4 lengthOfUserDefinedTypeName = new AS400Bin4();
	// 304 130 CHAR(128) User-defined type name
	AS400Text userDefinedTypeName = new AS400Text(128);
	// 432 1B0 CHAR(10) User-defined type library name
	AS400Text userDefinedTypeLibraryName = new AS400Text(10);
	// 442 1BA CHAR(1) Datalink link control
	AS400Text datalinkLinkControl = new AS400Text(1);
	// 443 1BB CHAR(1) Datalink integrity
	AS400Text datalinkIntegrity = new AS400Text(1);
	// 444 1BC CHAR(1) Datalink read permission
	AS400Text datalinkReadPermission = new AS400Text(1);
	// 445 1BD CHAR(1) Datalink write permission
	AS400Text datalinkWritePermission = new AS400Text(1);
	// 446 1BE CHAR(1) Datalink recovery
	AS400Text datalinkRecovery = new AS400Text(1);
	// 447 1BF CHAR(1) Datalink unlink control
	AS400Text datalinkUnlinkControl = new AS400Text(1);
	// 448 1C0 BINARY(4) Display or print row number
	AS400Bin4 displayOrPrintRowNumber = new AS400Bin4();
	// 452 1C4 BINARY(4) Display or print column number
	AS400Bin4 displayOrPrintColumnNumber = new AS400Bin4();
	// 456 1C8 CHAR(1) ROWID column
	AS400Text rowIDColumn = new AS400Text(1);
	// 457 1C9 CHAR(1) Identity column
	AS400Text identityColumn = new AS400Text(1);
	// 458 1CA CHAR(1) GENERATED BY
	AS400Text generatedBy = new AS400Text(1);
	// 459 1CB CHAR(1) Identity column - CYCLE
	AS400Text identityColumnCycle = new AS400Text(1);
	// 460 1CC DECIMAL(31,0) Identity column - Original START WITH
	AS400PackedDecimal identityColumnOriginalStartWith = new AS400PackedDecimal(
			31, 0);
	// 476 1DC DECIMAL(31,0) Identity column - Current START WITH
	AS400PackedDecimal identityColumnCurrentStartsWith = new AS400PackedDecimal(
			31, 0);
	// 492 1EC BINARY(4) Identity column - INCREMENT BY
	AS400Bin4 identityColumnIncrementBy = new AS400Bin4();
	// 496 1F0 DECIMAL(31,0) Identity column - MINVALUE
	AS400PackedDecimal identityColumnMinValue = new AS400PackedDecimal(31, 0);
	// 512 200 DECIMAL(31,0) Identity column - MAXVALUE
	AS400PackedDecimal identityColumnMaxValue = new AS400PackedDecimal(31, 0);
	// 528 210 BINARY(4) Identity column - CACHE
	AS400Bin4 identityColumnCache = new AS400Bin4();
	// 532 214 CHAR(1) Identity column - ORDER
	AS400Text identityColumnOrder = new AS400Text(1);
	// 533 215 CHAR(1) Implicitly hidden
	AS400Text implicitlyHidden = new AS400Text(1);
	// 534 216 CHAR(1) Row change timestamp GENERATED
	AS400Text rowChangeTimestampGenerated = new AS400Text(1);
	// 535 217 CHAR(10) Field Procedure program name
	AS400Text fieldProcedureProgramName = new AS400Text(10);
	// 545 221 CHAR(10) Field Procedure library name
	AS400Text fieldProcedureLibraryName = new AS400Text(10);
	// Start of change555 22B BINARY(2) Timestamp precision
	AS400Bin2 timestampPrecision = new AS400Bin2();
	// 557 22D CHAR(3)End of change Reserved
	AS400Text reserved0100 = new AS400Text(3);

	AS400DataType[] FLDL0100a = new AS400DataType[] { 
			fieldName, 
			dataType, 
			use,
			outputBufferPosition, 
			inputBufferPosition, 
			fieldLengthInBytes,
			digits, 
			decimalPositions, 
			fieldTextDescription, 
			editCode,
			editWordLength, 
			editWord, 
			columnHeading1, 
			columnHeading2,
			columnHeading3, 
			internalFieldName, 
			alternativeFieldName,
			alternativeFieldNameLength, 
			numberOfDBCSCharacters,
			nullValuesAllowed, 
			hostVariableIndicator, 
			dateAndTimeFormat,
			dateAndTimeSeparator, 
			variableLengthFieldIndicator,
			fieldTextDescriptionCCSID, 
			fieldDataCCSID,
			fieldColumnHeadingsCCSID, 
			fieldEditWordsCCSID,
			ucs2DisplayedFieldLength, 
			fieldDataEncodingScheme,
			maximumLargeObjectFieldLength, 
			padLengthForLargeObject,
			lengthOfUserDefinedTypeName, 
			userDefinedTypeName,
			userDefinedTypeLibraryName, 
			datalinkLinkControl, 
			datalinkIntegrity,
			datalinkReadPermission, 
			datalinkWritePermission, 
			datalinkRecovery,
			datalinkUnlinkControl, 
			displayOrPrintRowNumber,
			displayOrPrintColumnNumber, 
			rowIDColumn, 
			identityColumn,
			generatedBy, 
			identityColumnCycle, 
			identityColumnOriginalStartWith,
			identityColumnCurrentStartsWith, 
			identityColumnIncrementBy,
			identityColumnMinValue, 
			identityColumnMaxValue,
			identityColumnCache, 
			identityColumnOrder, 
			implicitlyHidden,
			rowChangeTimestampGenerated, 
			fieldProcedureProgramName,
			fieldProcedureLibraryName, 
			timestampPrecision, 
			reserved0100 
			};

	//
	//
	// FLDL0200 List Data Section
	//
	// dir
	// Offset Type Field
	// Dec Hex
	// 0 0 BINARY(4) Length of FLDL0200 format
	AS400Bin4 lengthOfFLDL0200Format = new AS400Bin4();
	// 4 4 BINARY(4) Displacement to default value
	AS400Bin4 displacementToDefaultValueFLDL0200 = new AS400Bin4();
	// 8 8 BINARY(4) Length of default value
	AS400Bin4 lengthOfDefaultValueFLDL0200 = new AS400Bin4();
	// 12 C All fields defined by FLDL0100 format
	// FIXME Put all the above fields here
	// * * CHAR(*) Default value
	// FIXME create an AS400Text at runtime to capture the value
	AS400DataType[] FLDL0200a = new AS400DataType[] { 
			lengthOfFLDL0200Format,
			displacementToDefaultValueFLDL0200, 
			lengthOfDefaultValueFLDL0200
			// FLDL0100
			// CHAR(*) Alternative Field Name
			// CHAR(*) DefaultValue
	};
	
	//
	//
	// FLDL0300 List Data Section
	//
	// Offset Type Field
	// Dec Hex
	// 0 0 BINARY(4) Length of FLDL0300 format
	AS400Bin4 lengthOfFLDL0300Format = new AS400Bin4();
	// 4 4 BINARY(4) Displacement to all fields defined by FLDL0100 format
	AS400Bin4 displacementToAllFieldsDefinedByFLDL0100Format = new AS400Bin4();
	// 8 8 BINARY(4) Displacement to alternative field name
	AS400Bin4 displacementToAlternativeFieldName = new AS400Bin4();
	// 12 C BINARY(4) Displacement to default value
	AS400Bin4 displacementToDefaultValueFLDL0300 = new AS400Bin4();
	// 16 10 BINARY(4) Length of default value
	AS400Bin4 lengthOfDefaultValueFLDL0300 = new AS400Bin4();
	// * * All fields defined by FLDL0100 format
	// FIXME Put all the above fields here
	// * * CHAR(*) Alternative field name (long)
	// FIXME create an AS400Text at runtime to capture the value
	// * * CHAR(*) Default value
	// FIXME create an AS400Text at runtime to capture the value
	AS400DataType[] FLDL0300a = new AS400DataType[] { 
			lengthOfFLDL0300Format,
			displacementToAllFieldsDefinedByFLDL0100Format,
			displacementToAlternativeFieldName,
			displacementToDefaultValueFLDL0300, 
			lengthOfDefaultValueFLDL0300
			// FLDL0100
			// CHAR(*) Alternative Field Name
			// CHAR(*) DefaultValue
	};

	AS400Structure FLDL0300 = new AS400Structure();
	AS400Structure FLDL0200 = new AS400Structure();
	AS400Structure FLDL0100 = new AS400Structure();

	public APIDeviceFileInfoProvider() {
		FLDL0300.setMembers(FLDL0300a);
	}

}