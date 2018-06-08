package app.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

/**
 * Used to simplify pagination. Wraps a <code> {@link Page} </code> instance and
 * adds needed parameters for the pagination.
 * 
 * @author Mirna Baksa
 *
 * @param <T>
 *            type of data displayed in a <code> {@link Page} </code>
 */
public class PageWrapper<T> {
	/** Wrapped instance. **/
	private Page<T> page;
	/** All pages. **/
	private List<PageItem> pages;
	/** Index url. **/
	private String url;
	/** Number of current page displayed. */
	private int number;

	public PageWrapper(Page<T> page, String url) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<>();
		this.number = page.getNumber();

		for (int i = 0; i < page.getTotalPages(); i++)
			this.pages.add(new PageItem(false, i + 1));
		this.pages.get(number).setCurrent(true);
	}

	public Page<T> getPage() {
		return page;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public boolean isHasNextPage() {
		return page.hasNext();
	}

	public boolean isHasPreviousPage() {
		return page.hasPrevious();
	}

	public String getUrl() {
		return url;
	}

	public int getNumber() {
		return number;
	}

}

/**
 * Represents a single Page, denoted by its number and a flag which notes if it
 * is the current page displayed.
 * 
 * @author Mirna Baksa
 *
 */
class PageItem {
	private boolean current;
	private int pageNumber;

	public PageItem(boolean current, int pageNumber) {
		this.current = current;
		this.pageNumber = pageNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public boolean getCurrent() {
		return this.current;
	}

}
