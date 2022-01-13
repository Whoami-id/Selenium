
package reporter;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFReporter implements ITestListener {
    /**
     * Documents
     */
    private Document document = null;

    /**
     * PdfPTables
     */
    PdfPTable successTable = null, failTable = null;

    /**
     * throwableMap
     */
    private HashMap<Integer, Throwable> throwableMap = null;

    /**
     * nbExceptions
     */
    private int nbExceptions = 0;

    /**
     * JyperionListener
     */
    public PDFReporter() {
        log("JyperionListener()");

        this.document = new Document();
        this.throwableMap = new HashMap<>();
    }

    /**
     * .ITestListener onTestSuccess
     */
    @Override
    public void onTestSuccess(final ITestResult result) {
        log("onTestSuccess(" + result + ")");

        if (successTable == null) {
            this.successTable = new PdfPTable(new float[] { .3f, .3f, .1f, .3f });
            final Paragraph p = new Paragraph("PASSED TESTS",
                    new Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC, new BaseColor(0, 0, 255)));
            p.setAlignment(Element.ALIGN_CENTER);
            PdfPCell cell = new PdfPCell(p);
            cell.setColspan(4);
            cell.setBackgroundColor(BaseColor.GREEN);
            this.successTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("Class"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.successTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Method"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.successTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Time (ms)"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.successTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Exception"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.successTable.addCell(cell);

        }

        PdfPCell cell = new PdfPCell(new Paragraph(result.getTestClass().toString()));
        this.successTable.addCell(cell);
        cell = new PdfPCell(new Paragraph(result.getMethod().toString()));
        this.successTable.addCell(cell);
        cell = new PdfPCell(new Paragraph("" + (result.getEndMillis() - result.getStartMillis())));
        this.successTable.addCell(cell);

        final Throwable throwable = result.getThrowable();
        if (throwable != null) {
            this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
            this.nbExceptions++;
            final Paragraph excep = new Paragraph(new Chunk(throwable.toString(),
                    new Font(FontFamily.HELVETICA, 10, Font.BOLDITALIC, new BaseColor(255, 0, 0)))
                            .setLocalGoto("" + throwable.hashCode()));
            cell = new PdfPCell(excep);
            this.successTable.addCell(cell);
        } else {
            this.successTable.addCell(new PdfPCell(new Paragraph("")));
        }
    }

    /**
     * ITestListener onTestFailure
     */
    @Override
    public void onTestFailure(final ITestResult result) {
        log("onTestFailure(" + result + ")");
        if (this.failTable == null) {
            this.failTable = new PdfPTable(new float[] { .3f, .3f, .1f, .3f });
            this.failTable.setTotalWidth(5f);
            final Paragraph p = new Paragraph("FAILED TESTS",
                    new Font(FontFamily.HELVETICA, 18, Font.BOLDITALIC, new BaseColor(0, 0, 255)));
            p.setAlignment(Element.ALIGN_CENTER);
            PdfPCell cell = new PdfPCell(p);
            cell.setColspan(4);
            cell.setBackgroundColor(BaseColor.RED);
            this.failTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("Class"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.failTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Method"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.failTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Time (ms)"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.failTable.addCell(cell);
            cell = new PdfPCell(new Paragraph("Exception"));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            this.failTable.addCell(cell);

        }

        PdfPCell cell = new PdfPCell(new Paragraph(result.getTestClass().toString()));
        this.failTable.addCell(cell);
        cell = new PdfPCell(new Paragraph(result.getMethod().toString()));
        this.failTable.addCell(cell);
        cell = new PdfPCell(new Paragraph("" + (result.getEndMillis() - result.getStartMillis())));
        this.failTable.addCell(cell);

        final Throwable throwable = result.getThrowable();
        if (throwable != null) {
            this.throwableMap.put(new Integer(throwable.hashCode()), throwable);
            this.nbExceptions++;
            final Paragraph excep = new Paragraph(new Chunk(throwable.toString(),
                    new Font(FontFamily.HELVETICA, 10, Font.BOLDITALIC, new BaseColor(255, 0, 0)))
                            .setLocalGoto("" + throwable.hashCode()));
            cell = new PdfPCell(excep);
            this.failTable.addCell(cell);
        } else {
            this.failTable.addCell(new PdfPCell(new Paragraph("")));
        }
    }

    /**
     * ITestListener onTestSkipped
     */
    @Override
    public void onTestSkipped(final ITestResult result) {
        log("onTestSkipped(" + result + ")");
    }

    /**
     * ITestListener onStart
     */
    @Override
    public void onStart(final ITestContext context) {
        log("onStart(" + context + ")");
        try {
            PdfWriter.getInstance(this.document, new FileOutputStream(System.getProperty("user.dir")
                    + "\\src\\main\\resources\\TestReporter\\" + context.getName() + ".pdf"));
        } catch (final Exception e) {
            e.printStackTrace();
        }
        this.document.open();

        final Paragraph p = new Paragraph(context.getName() + " TESTNG RESULTS",
                FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, new BaseColor(0, 0, 255)));

        try {
            this.document.add(p);
            this.document.add(new Paragraph(new Date().toString()));
        } catch (final DocumentException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * ITestListener onFinish
     */
    @Override
    public void onFinish(final ITestContext context) {
        log("onFinish(" + context + ")");

        try {
            if (this.failTable != null) {
                log("Added fail table");
                this.failTable.setSpacingBefore(15f);
                this.document.add(this.failTable);
                this.failTable.setSpacingAfter(15f);
            }
            if (this.successTable != null) {
                log("Added success table");
                this.successTable.setSpacingBefore(15f);
                this.document.add(this.successTable);
                this.successTable.setSpacingBefore(15f);
            }
        } catch (final DocumentException e) {
            e.printStackTrace();
        }

        final Paragraph p = new Paragraph("EXCEPTIONS SUMMARY",
                FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new BaseColor(255, 0, 0)));
        try {
            this.document.add(p);
        } catch (final DocumentException e1) {
            e1.printStackTrace();
        }

        final Set<Integer> keys = this.throwableMap.keySet();

        assert keys.size() == this.nbExceptions;

        for (final Integer key : keys) {
            final Throwable throwable = this.throwableMap.get(key);

            final Chunk chunk = new Chunk(throwable.toString(),
                    FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new BaseColor(255, 0, 0)));
            chunk.setLocalDestination("" + key);
            final Paragraph throwTitlePara = new Paragraph(chunk);
            try {
                this.document.add(throwTitlePara);
            } catch (final DocumentException e3) {
                e3.printStackTrace();
            }

            final StackTraceElement[] elems = throwable.getStackTrace();
            for (final StackTraceElement ste : elems) {
                final Paragraph throwParagraph = new Paragraph(ste.toString());
                try {
                    this.document.add(throwParagraph);
                } catch (final DocumentException e2) {
                    e2.printStackTrace();
                }
            }
        }

        this.document.close();
    }

    /**
     * log
     *
     * @param o
     */
    public static void log(final Object o) {
        // System.out.println("[JyperionListener] " + o);
    }

    @Override
    public void onTestStart(final ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
    }
}
