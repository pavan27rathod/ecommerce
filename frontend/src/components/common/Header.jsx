export default function Header() {
  return (
    <header className="w-full font-sans">
      {/* TOP BAR */}
      <div className="border-b border-[#d6d6d6]">
        <div className="flex items-center justify-between h-[64px] px-[24px] max-w-[1440px] mx-auto">
          
          {/* Logo */}
          <div className="flex items-center gap-[8px]">
            <span className="text-[28px] font-semibold text-[#0070c9]">
              element<span className="text-[#f57c00]">14</span>
            </span>
            <span className="text-[10px] text-[#6b6b6b] uppercase mt-[6px]">
              an avnet company
            </span>
          </div>

          {/* Search */}
          <div className="flex items-center border border-[#9e9e9e] h-[40px] w-[600px]">
            <select className="h-full px-[12px] text-[14px] border-r border-[#9e9e9e] bg-[#efefef] focus:outline-none">
              <option>All</option>
            </select>
            <input
              type="text"
              placeholder="Keyword / Part #"
              className="flex-1 h-full px-[12px] text-[14px] focus:outline-none"
            />
            <button className="h-full w-[48px] bg-[#0070c9] text-white flex items-center justify-center">
              🔍
            </button>
          </div>

          {/* Account + Cart */}
          <div className="flex items-center gap-[32px] text-[13px] text-[#333]">
            <div className="flex items-center gap-[8px] cursor-pointer">
              <span className="text-[#2e7d32] text-[18px]">👤</span>
              <div className="leading-tight">
                <div className="font-semibold">Login</div>
                <div className="text-[12px]">My Account</div>
              </div>
            </div>

            <div className="flex items-center gap-[8px] cursor-pointer">
              <span className="text-[#2e7d32] text-[18px]">🛒</span>
              <div className="leading-tight">
                <div>0 Items</div>
                <div className="text-[12px]">Rs.0.00</div>
              </div>
            </div>
          </div>
        </div>
      </div>

      {/* BOTTOM NAV */}
      <nav>
        <ul className="flex items-center h-[48px] px-[24px] gap-[32px] text-white text-[15px] font-medium">
            <li className="flex items-center gap-[6px] cursor-pointer">
            All Products
            <span className="text-[12px] mt-[1px]">▾</span>
            </li>

            <li className="flex items-center gap-[6px] cursor-pointer">
            Manufacturers
            <span className="text-[12px] mt-[1px]">▾</span>
            </li>

            <li className="flex items-center gap-[6px] cursor-pointer">
            Resources
            <span className="text-[12px] mt-[1px]">▾</span>
            </li>

            <li className="flex items-center gap-[6px] cursor-pointer">
            Communities
            <span className="text-[12px] mt-[1px]">▾</span>
            </li>
        </ul>
        </nav>

    </header>
  );
}
